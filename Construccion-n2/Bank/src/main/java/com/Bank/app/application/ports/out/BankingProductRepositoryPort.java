package com.Bank.app.application.ports.out;

import com.Bank.app.domain.model.BankingProduct;
import java.util.Optional;

public interface BankingProductRepositoryPort {

    Optional<BankingProduct> findByCode(String code);
}