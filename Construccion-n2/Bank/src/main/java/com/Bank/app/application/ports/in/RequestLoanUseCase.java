package main.java.com.Bank.app.application.ports.in;

import com.Bank.app.application.dto.LoanRequest;
import com.Bank.app.domain.model.Loans;

public interface RequestLoanUseCase {
    Loans execute(LoanRequest request);
}