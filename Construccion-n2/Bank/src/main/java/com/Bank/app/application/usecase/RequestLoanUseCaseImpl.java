package com.Bank.app.application.usecase;

import com.Bank.app.application.dto.LoanRequest;
import com.Bank.app.application.ports.in.RequestLoanUseCase;
import com.Bank.app.application.ports.out.ClientRepositoryPort;
import com.Bank.app.application.ports.out.LoanRepositoryPort;
import com.Bank.app.domain.exceptions.DomainException;
import com.Bank.app.domain.model.Loans;
import com.Bank.app.domain.model.vo.Money;
import org.springframework.stereotype.Service; 

@Service 
public class RequestLoanUseCaseImpl implements RequestLoanUseCase {

    private final LoanRepositoryPort loanRepositoryPort;
    private final ClientRepositoryPort clientRepositoryPort;

    public RequestLoanUseCaseImpl(LoanRepositoryPort loanRepositoryPort, ClientRepositoryPort clientRepositoryPort) {
        this.loanRepositoryPort = loanRepositoryPort;
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Loans execute(LoanRequest request) {
        if (!clientRepositoryPort.existsByIdentification(request.getIdClienteSolicitante())) {
            throw new DomainException("No se puede solicitar un préstamo para un cliente inexistente.");
        }

        Loans loan = new Loans();
        loan.setTipoPrestamo(request.getTipoPrestamo());
        loan.setIdClienteSolicitante(request.getIdClienteSolicitante());

        loan.setMontoSolicitado(new Money(request.getMontoSolicitado()));
        
        loan.setTasaInteres(request.getTasaInteres());
        loan.setPlazoMeses(request.getPlazoMeses());
        loan.setCuentaDestinoDesembolso(request.getCuentaDestinoDesembolso());
        loan.setEstadoPrestamo("EN_ESTUDIO"); 

        return loanRepositoryPort.save(loan);
    }
}