package main.java.com.Bank.app.application.usecase;

import com.Bank.app.application.dto.TransferRequest;
import com.Bank.app.application.ports.in.CreateTransferUseCase;
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

public class CreateTransferUseCaseImpl implements CreateTransferUseCase {

    private final TransferRepositoryPort transferRepositoryPort;
    private final BankAccountRepositoryPort accountRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;
    private final AuditLogPort auditLogPort;

    private static final Double UMBRAL_EMPRESA = 5000000.0;

    public CreateTransferUseCaseImpl(TransferRepositoryPort transferRepositoryPort, BankAccountRepositoryPort accountRepositoryPort, 
                                     UserRepositoryPort userRepositoryPort, AuditLogPort auditLogPort) {
        this.transferRepositoryPort = transferRepositoryPort;
        this.accountRepositoryPort = accountRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
        this.auditLogPort = auditLogPort;
    }

    @Override
    public Transfer execute(TransferRequest request) {
        User user = userRepositoryPort.findById(request.getIdUsuarioCreador())
                .orElseThrow(() -> new DomainException("Usuario creador no encontrado."));

        Bankaccount source = accountRepositoryPort.findByNumber(request.getCuentaOrigen())
                .orElseThrow(() -> new DomainException("La cuenta de origen no existe."));

        Bankaccount destination = accountRepositoryPort.findByNumber(request.getCuentaDestino())
                .orElseThrow(() -> new DomainException("La cuenta de destino no existe."));

        Transfer transfer = new Transfer();
        transfer.setCuentaOrigen(request.getCuentaOrigen());
        transfer.setCuentaDestino(request.getCuentaDestino());
        transfer.setMonto(request.getMonto());
        transfer.setFechaCreacion(LocalDateTime.now());
        transfer.setIdUsuarioCreador(request.getIdUsuarioCreador());


        if ("Empleado de Empresa".equals(user.getRolSistema()) && request.getMonto() > UMBRAL_EMPRESA) {
            transfer.setEstadoTransferencia("En espera de aprobación");
            return transferRepositoryPort.save(transfer);
        }


        if (source.getSaldoActual() < request.getMonto()) {
            throw new DomainException("Saldo insuficiente para realizar la transferencia.");
        }

        source.setSaldoActual(source.getSaldoActual() - request.getMonto());
        destination.setSaldoActual(destination.getSaldoActual() + request.getMonto());

        accountRepositoryPort.save(source);
        accountRepositoryPort.save(destination);

        transfer.setEstadoTransferencia("Ejecutada");
        Transfer savedTransfer = transferRepositoryPort.save(transfer);

        OperationLog log = new OperationLog();
        log.setTipoOperacion("TRANSFERENCIA_EJECUTADA");
        log.setFechaHoraOperacion(LocalDateTime.now());
        log.setIdUsuario(request.getIdUsuarioCreador());
        log.setRolUsuario(user.getRolSistema());
        log.setIdProductoAfectado(savedTransfer.getIdTransferencia().toString());
        auditLogPort.save(log);

        return savedTransfer;
    }
}