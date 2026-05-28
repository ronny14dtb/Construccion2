package com.Bank.app.application.usecase;

import com.Bank.app.application.ports.in.DisburseLoanUseCase;
import com.Bank.app.application.ports.out.BankAccountRepositoryPort;
import com.Bank.app.application.ports.out.LoanRepositoryPort;
import com.Bank.app.application.ports.out.UserRepositoryPort;
import com.Bank.app.domain.exceptions.DomainException;
import com.Bank.app.domain.model.Bankaccount;
import com.Bank.app.domain.model.Loans;
import com.Bank.app.domain.model.User;
import com.Bank.app.domain.constant.StateAccount; 
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;


@Service
public class DisburseLoanUseCaseImpl implements DisburseLoanUseCase {

    private final LoanRepositoryPort loanRepositoryPort;
    private final BankAccountRepositoryPort accountRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    public DisburseLoanUseCaseImpl(LoanRepositoryPort loanRepositoryPort, 
                                   BankAccountRepositoryPort accountRepositoryPort, 
                                   UserRepositoryPort userRepositoryPort) {
        this.loanRepositoryPort = loanRepositoryPort;
        this.accountRepositoryPort = accountRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Loans execute(Long loanId, Integer analystId) {
        User user = userRepositoryPort.findById(analystId)
                .orElseThrow(() -> new DomainException("Usuario no encontrado."));

        Loans loan = loanRepositoryPort.findById(loanId)
                .orElseThrow(() -> new DomainException("Préstamo no encontrado."));

        if (!"APROBADO".equals(loan.getEstadoPrestamo())) {
            throw new DomainException("El desembolso solo es posible si el préstamo está 'APROBADO'.");
        }

        Bankaccount destinationAccount = accountRepositoryPort.findByNumber(loan.getCuentaDestinoDesembolso())
                .orElseThrow(() -> new DomainException("La cuenta de destino para el desembolso no existe."));

        if (destinationAccount.getEstado() != StateAccount.ACTIVA) {
            throw new DomainException("La cuenta de destino se encuentra inactiva o bloqueada.");
        }


        destinationAccount.setSaldoActual(destinationAccount.getSaldoActual().add(loan.getMontoAprobado()));
        
        accountRepositoryPort.save(destinationAccount);

        loan.setEstadoPrestamo("DESEMBOLSADO");
        loan.setFechaDesembolso(LocalDateTime.now());
        
        return loanRepositoryPort.save(loan);
    }
}