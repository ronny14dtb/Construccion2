package main.java.com.Bank.app.application.ports.out;

import com.Bank.app.domain.model.Bankaccount;
import java.util.Optional;

public interface BankAccountRepositoryPort {
    Bankaccount save(Bankaccount account);
    Optional<Bankaccount> findByNumber(String accountNumber);
}