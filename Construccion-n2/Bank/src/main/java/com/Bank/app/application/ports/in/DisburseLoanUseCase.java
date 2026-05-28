package com.Bank.app.application.ports.in;


import com.Bank.app.domain.model.Loans;

public interface DisburseLoanUseCase {
    Loans execute(Long loanId, Integer analystId);
}