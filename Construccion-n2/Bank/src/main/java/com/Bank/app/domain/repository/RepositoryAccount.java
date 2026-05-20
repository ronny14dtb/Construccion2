package com.Bank.app.domain.repository;

import com.Bank.app.domain.model.Bankaccount;

public interface RepositoryAccount {
    Bankaccount findByNumber(String number);
    void save(Bankaccount account);
}