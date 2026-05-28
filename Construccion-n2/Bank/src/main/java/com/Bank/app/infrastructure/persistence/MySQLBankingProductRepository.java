package com.Bank.app.infrastructure.persistence;


import com.Bank.app.domain.model.BankingProduct; 
import com.Bank.app.application.ports.out.BankingProductRepositoryPort;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class MySQLBankingProductRepository implements BankingProductRepositoryPort {


    @Override
    public Optional<BankingProduct> findByCode(String code) {

        return Optional.empty();
    }
}