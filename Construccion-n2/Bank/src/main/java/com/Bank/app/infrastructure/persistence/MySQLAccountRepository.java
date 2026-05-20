package com.Bank.app.infrastructure.persistence;

import com.Bank.app.domain.model.Bankaccount;
import com.Bank.app.domain.repository.RepositoryAccount;
import org.springframework.stereotype.Component;

@Component
public class MySQLAccountRepository implements RepositoryAccount {


    @Override
    public void save(Bankaccount account) {
        System.out.println("Guardando cuenta en MySQL...");

    }

    @Override
    public Bankaccount findByNumber(String number) {

        return null; 
    }
}