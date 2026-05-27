package com.Bank.app.domain.infrastructure.adapter.sql.repository;
import com.Bank.app.domain.model.Bankaccount;

public interface BankAccountJpaRepository {
    Bankaccount findByNumber(String number);
    void save(Bankaccount account);
}