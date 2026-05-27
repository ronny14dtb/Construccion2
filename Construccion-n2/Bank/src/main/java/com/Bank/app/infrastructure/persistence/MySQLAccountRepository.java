package com.Bank.app.infrastructure.persistence;

import com.Bank.app.application.ports.out.BankAccountRepositoryPort;
import com.Bank.app.domain.model.Bankaccount;
import com.Bank.app.infrastructure.adapter.sql.entity.BankAccountEntity;
import com.Bank.app.infrastructure.adapter.sql.repository.BankAccountJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MySQLAccountRepository implements BankAccountRepositoryPort {

    private final BankAccountJpaRepository jpaRepository;

    public MySQLAccountRepository(BankAccountJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Bankaccount save(Bankaccount account) {
        BankAccountEntity entity = new BankAccountEntity();
        entity.setNumeroCuenta(account.getNumeroCuenta());
        entity.setTipoCuenta(account.getTipoCuenta());
        entity.setIdTitular(account.getIdTitular());
        entity.setSaldoActual(account.getSaldoActual());
        entity.setMoneda(account.getMoneda());
        entity.setEstadoCuenta(account.getEstadoCuenta());


        BankAccountEntity savedEntity = jpaRepository.save(entity);


        account.setNumeroCuenta(savedEntity.getNumeroCuenta());
        return account;
    }

    @Override
    public Optional<Bankaccount> findByNumber(String accountNumber) {
        return jpaRepository.findByNumeroCuenta(accountNumber)
                .map(entity -> {
                    Bankaccount domainAccount = new Bankaccount();
                    domainAccount.setNumeroCuenta(entity.getNumeroCuenta());
                    domainAccount.setTipoCuenta(entity.getTipoCuenta());
                    domainAccount.setIdTitular(entity.getIdTitular());
                    domainAccount.setSaldoActual(entity.getSaldoActual());
                    domainAccount.setMoneda(entity.getMoneda());
                    domainAccount.setEstadoCuenta(entity.getEstadoCuenta());
                    return domainAccount;
                });
    }
}