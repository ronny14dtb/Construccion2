package main.java.com.Bank.app.infrastructure.persistence;

import main.java.com.Bank.app.application.ports.out.LoanRepositoryPort;
import main.java.com.Bank.app.domain.model.Loans;
import main.java.com.Bank.app.infrastructure.adapter.sql.entity.LoanEntity;
import main.java.com.Bank.app.infrastructure.adapter.sql.repository.RepositoryLoans;
import org.springframework.stereotype.Component;

@Component
public class MySQLLoanRepository implements LoanRepositoryPort {

    private final RepositoryLoans repositoryLoans;

    public MySQLLoanRepository(RepositoryLoans repositoryLoans) {
        this.repositoryLoans = repositoryLoans;
    }

    @Override
    public Loans save(Loans loan) {

        LoanEntity entity = new LoanEntity();
        entity.setTipoPrestamo(loan.getTipoLoan());
        entity.setIdClienteSolicitante(loan.getIdClienteSolicitante());
        entity.setMontoSolicitado(loan.getMontoSolicitado());
        entity.setTasaInteres(loan.getTasaInteres());
        entity.setPlazoMeses(loan.getPlazoMeses());
        entity.setCuentaDestinoDesembolso(loan.getCuentaDestinoDesembolso());
        entity.setEstadoParstamo(loan.getEstadoPrestamo());

        LoanEntity savedEntity = repositoryLoans.save(entity);
        
        loan.setId(savedEntity.getIdPrestamo());
        return loan;
    }
}