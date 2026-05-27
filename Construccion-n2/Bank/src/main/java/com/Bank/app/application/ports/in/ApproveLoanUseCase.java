package main.java.com.Bank.app.application.ports.in;
import com.Bank.app.domain.model.Loans;

public interface ApproveLoanUseCase {
    Loans execute(Long loanId, Integer analystId);
}