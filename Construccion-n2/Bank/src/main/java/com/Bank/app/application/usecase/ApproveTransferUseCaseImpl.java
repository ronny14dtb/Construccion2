package com.Bank.app.application.usecase;

import com.Bank.app.application.ports.in.ApproveTransferUseCase;
import com.Bank.app.application.ports.out.AuditLogPort;
import com.Bank.app.application.ports.out.BankAccountRepositoryPort;
import com.Bank.app.application.ports.out.TransferRepositoryPort;
import com.Bank.app.application.ports.out.UserRepositoryPort;
import com.Bank.app.domain.exceptions.DomainException;
import com.Bank.app.domain.model.Bankaccount;
import com.Bank.app.domain.model.OperationLog;
import com.Bank.app.domain.model.Transfer;
import com.Bank.app.domain.model.User;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service

public class ApproveTransferUseCaseImpl implements ApproveTransferUseCase {

    private final TransferRepositoryPort transferRepositoryPort;
    private final BankAccountRepositoryPort accountRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;
    private final AuditLogPort auditLogPort;

    public ApproveTransferUseCaseImpl(TransferRepositoryPort transferRepositoryPort, BankAccountRepositoryPort accountRepositoryPort, 
                                      UserRepositoryPort userRepositoryPort, AuditLogPort auditLogPort) {
        this.transferRepositoryPort = transferRepositoryPort;
        this.accountRepositoryPort = accountRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
        this.auditLogPort = auditLogPort;
    }

    @Override
    public Transfer execute(Long transferId, Integer supervisorId, boolean approve) {
        User user = userRepositoryPort.findById(supervisorId)
                .orElseThrow(() -> new DomainException("Supervisor no encontrado."));

        if (!"Supervisor de Empresa".equals(user.getRolSistema())) {
            throw new DomainException("Solo un Supervisor de Empresa puede aprobar transferencias retenidas.");
        }

        Transfer transfer = transferRepositoryPort.findById(transferId)
                .orElseThrow(() -> new DomainException("Transferencia no encontrada."));

        if (!"En espera de aprobación".equals(transfer.getEstadoTransferencia())) {
            throw new DomainException("La transferencia no se encuentra en estado pendiente de aprobación.");
        }

        if (!approve) {
            transfer.setEstadoTransferencia("Rechazada");
            return transferRepositoryPort.save(transfer);
        }


        Bankaccount source = accountRepositoryPort.findByNumber(transfer.getCuentaOrigen())
                .orElseThrow(() -> new DomainException("Cuenta de origen inválida."));
        Bankaccount destination = accountRepositoryPort.findByNumber(transfer.getCuentaDestino())
                .orElseThrow(() -> new DomainException("Cuenta de destino inválida."));

        if (source.getSaldoActual().compareTo(transfer.getMonto()) < 0) {
            throw new DomainException("La cuenta origen ya no posee fondos suficientes.");
        }

        source.setSaldoActual(source.getSaldoActual().subtract(transfer.getMonto()));
        destination.setSaldoActual(destination.getSaldoActual().add(transfer.getMonto()));

        accountRepositoryPort.save(source);
        accountRepositoryPort.save(destination);

        transfer.setEstadoTransferencia("Ejecutada");
        transfer.setFechaAprobacion(LocalDateTime.now());
        transfer.setIdUsuarioAprobador(supervisorId);

        Transfer savedTransfer = transferRepositoryPort.save(transfer);

        OperationLog log = new OperationLog();
        log.setTipoOperacion("TRANSFERENCIA_APROBADA_EMPRESA");
        log.setFechaHoraOperacion(LocalDateTime.now());
        log.setIdUsuario(supervisorId);
        log.setRolUsuario(user.getRolSistema());
        log.setIdProductoAfectado(transferId.toString());

        System.out.println("DEBUG: Preparando para guardar en MongoDB el log: " + log);
        
        try {
            auditLogPort.save(log);
            System.out.println("DEBUG: Guardado en MongoDB realizado con éxito.");
        } catch (Exception e) {
            System.out.println("DEBUG: ERROR al guardar en MongoDB: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println(">>> ¡A punto de guardar en MongoDB! ID de usuario: " + supervisorId);
        auditLogPort.save(log);

        return savedTransfer;
    }
}