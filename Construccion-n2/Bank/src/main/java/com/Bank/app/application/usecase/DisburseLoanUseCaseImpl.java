package main.java.com.Bank.app.application.usecase;

import com.Bank.app.application.ports.in.DisburseLoanUseCase;
import com.Bank.app.application.ports.out.AuditLogPort;
import com.Bank.app.application.ports.out.BankAccountRepositoryPort;
import com.Bank.app.application.ports.out.LoanRepositoryPort;
import com.Bank.app.application.ports.out.UserRepositoryPort;
import com.Bank.app.domain.exceptions.DomainException;
import com.Bank.app.domain.model.Bankaccount;
import com.Bank.app.domain.model.Loans;
import com.Bank.app.domain.model.OperationLog;
import com.Bank.app.domain.model.User;

import java.time.LocalDateTime;

public class DisburseLoanUseCaseImpl implements DisburseLoanUseCase {

    private final LoanRepositoryPort loanRepositoryPort;
    private final BankAccountRepositoryPort accountRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;
    private final AuditLogPort auditLogPort;

    public DisburseLoanUseCaseImpl(LoanRepositoryPort loanRepositoryPort, BankAccountRepositoryPort accountRepositoryPort, 
                                   UserRepositoryPort userRepositoryPort, AuditLogPort auditLogPort) {
        this.loanRepositoryPort = loanRepositoryPort;
        this.accountRepositoryPort = accountRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
        this.auditLogPort = auditLogPort;
    }

    @Override
    public Loans execute(Long loanId, Integer analystId) {
        User user = userRepositoryPort.findById(analystId)
                .orElseThrow(() -> new DomainException("Usuario no encontrado."));

        Loans loan = loanRepositoryPort.findById(loanId)
                .orElseThrow(() -> new DomainException("Préstamo no encontrado."));

        if (!"Aprobado".equals(loan.getEstadoPrestamo())) {
            throw new DomainException("El desembolso solo es posible si el préstamo está 'Aprobado'.");
        }


        Bankaccount destinationAccount = accountRepositoryPort.findByNumber(loan.getCuentaDestinoDesembolso())
                .orElseThrow(() -> new DomainException("La cuenta de destino para el desembolso no existe."));

        if (!"Activa".equals(destinationAccount.getEstadoCuenta())) {
            throw new DomainException("La cuenta de destino se encuentra inactiva o bloqueada.");
        }


        destinationAccount.setSaldoActual(destinationAccount.getSaldoActual() + loan.getMontoAprobado());
        accountRepositoryPort.save(destinationAccount);

        loan.setEstadoPrestamo("Desembolsado");
        loan.setFechaDesembolso(LocalDateTime.now());
        Loans savedLoan = loanRepositoryPort.save(loan);

        OperationLog log = new OperationLog();
        log.setTipoOperacion("DESEMBOLSO_PRESTAMO");
        log.setFechaHoraOperacion(LocalDateTime.now());
        log.setIdUsuario(analystId);
        log.setRolUsuario(user.getRolSistema());
        log.setIdProductoAfectado(loanId.toString());
        auditLogPort.save(log);

        return savedLoan;
    }
}