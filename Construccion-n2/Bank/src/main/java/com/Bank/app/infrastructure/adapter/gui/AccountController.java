package com.Bank.app.infrastructure.adapter.gui;

import com.Bank.app.application.dto.BankAccountRequest;
import com.Bank.app.application.ports.in.OpenBankAccountUseCase;
import com.Bank.app.domain.model.Bankaccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final OpenBankAccountUseCase openBankAccountUseCase;

    public AccountController(OpenBankAccountUseCase openBankAccountUseCase) {
        this.openBankAccountUseCase = openBankAccountUseCase;
    }

    @PostMapping
    public ResponseEntity<Bankaccount> openAccount(@RequestBody BankAccountRequest request) {
        Bankaccount createdAccount = openBankAccountUseCase.execute(request);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
}