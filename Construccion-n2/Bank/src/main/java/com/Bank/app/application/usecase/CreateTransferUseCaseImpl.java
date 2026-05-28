package com.Bank.app.application.usecase;

import com.Bank.app.application.dto.TransferRequest;
import com.Bank.app.application.ports.in.CreateTransferUseCase;
import com.Bank.app.application.ports.out.*;
import com.Bank.app.domain.exceptions.DomainException;
import com.Bank.app.domain.model.*;
import com.Bank.app.domain.model.vo.Money;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CreateTransferUseCaseImpl implements CreateTransferUseCase {

    private final TransferRepositoryPort transferRepositoryPort;
    private final BankAccountRepositoryPort accountRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;
    private final AuditLogPort auditLogPort;

    private static final BigDecimal UMBRAL_EMPRESA = new BigDecimal("5000000.0");

    public CreateTransferUseCaseImpl(TransferRepositoryPort transferRepositoryPort, 
                                     BankAccountRepositoryPort accountRepositoryPort, 
                                     UserRepositoryPort userRepositoryPort, 
                                     AuditLogPort auditLogPort) {
        this.transferRepositoryPort = transferRepositoryPort;
        this.accountRepositoryPort = accountRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
        this.auditLogPort = auditLogPort;
    }

    @Override
    public Transfer execute(TransferRequest request) {


        Integer userId = Integer.valueOf(request.getIdUsuarioCreador());

        User user = userRepositoryPort.findById(userId)
                .orElseThrow(() -> new DomainException("Usuario creador no encontrado."));

        Bankaccount source = accountRepositoryPort.findByNumber(request.getCuentaOrigen())
                .orElseThrow(() -> new DomainException("La cuenta de origen no existe."));

        Bankaccount destination = accountRepositoryPort.findByNumber(request.getCuentaDestino())
                .orElseThrow(() -> new DomainException("La cuenta de destino no existe."));

        Money montoTransferir = new Money(request.getMonto());

        Transfer transfer = new Transfer();
        transfer.setCuentaOrigen(request.getCuentaOrigen());
        transfer.setCuentaDestino(request.getCuentaDestino());
        transfer.setMonto(montoTransferir);
        transfer.setFechaCreacion(LocalDateTime.now());
        transfer.setIdUsuarioCreador(userId);

  
        if ("Empleado de Empresa".equals(user.getRolSistema()) && request.getMonto().compareTo(UMBRAL_EMPRESA) > 0) {
            transfer.setEstadoTransferencia("En espera de aprobación");
            return transferRepositoryPort.save(transfer);
        }

        source.validarSaldo(montoTransferir);
        source.withdraw(montoTransferir);
        destination.deposit(montoTransferir);

        accountRepositoryPort.save(source);
        accountRepositoryPort.save(destination);

        transfer.setEstadoTransferencia("Ejecutada");
        Transfer savedTransfer = transferRepositoryPort.save(transfer);

 
        OperationLog log = new OperationLog();
        log.setTipoOperacion("TRANSFERENCIA_EJECUTADA");
        log.setFechaHoraOperacion(LocalDateTime.now());
        log.setIdUsuario(userId);
        log.setRolUsuario(user.getRolSistema());
        log.setIdProductoAfectado(String.valueOf(savedTransfer.getIdTransferencia()));
        auditLogPort.save(log);

        return savedTransfer;
    }
}