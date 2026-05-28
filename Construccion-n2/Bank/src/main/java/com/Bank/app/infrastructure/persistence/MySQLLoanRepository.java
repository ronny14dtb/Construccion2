package com.Bank.app.infrastructure.persistence;

import com.Bank.app.application.ports.out.LoanRepositoryPort;
import com.Bank.app.domain.model.Loans;
import com.Bank.app.infrastructure.adapter.sql.entity.LoanEntity;
import com.Bank.app.infrastructure.adapter.sql.repository.RepositoryLoans;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Optional;

@Component
public class MySQLLoanRepository implements LoanRepositoryPort {

    private final RepositoryLoans repositoryLoans;

    public MySQLLoanRepository(RepositoryLoans repositoryLoans) {
        this.repositoryLoans = repositoryLoans;
    }

    @Override
    public Loans save(Loans loan) {
        LoanEntity entity = new LoanEntity();
        entity.setTipoPrestamo(loan.getTipoPrestamo());
        entity.setIdClienteSolicitante(loan.getIdClienteSolicitante());
        entity.setMontoSolicitado(loan.getMontoSolicitado().getAmount());

        entity.setTasaInteres(BigDecimal.valueOf(loan.getTasaInteres()));

        entity.setPlazoMeses(loan.getPlazoMeses());
        entity.setCuentaDestinoDesembolso(loan.getCuentaDestinoDesembolso());
        entity.setEstadoPrestamo(loan.getEstadoPrestamo());

        LoanEntity savedEntity = repositoryLoans.save(entity);
        loan.setId(savedEntity.getIdPrestamo().longValue());
        return loan;
    }

@Override
public Optional<Loans> findById(Long id) {

    return repositoryLoans.findById(id.intValue()).map(entity -> { 
        Loans loan = new Loans();
        

        loan.setId(entity.getIdPrestamo().longValue()); 
        
        return loan;
    });
}
}