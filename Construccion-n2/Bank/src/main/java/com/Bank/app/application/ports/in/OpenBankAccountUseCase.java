package com.Bank.app.application.ports.in;

import com.Bank.app.application.dto.BankAccountRequest;
import com.Bank.app.domain.model.Bankaccount;

public interface OpenBankAccountUseCase {
    Bankaccount execute(BankAccountRequest request);
}