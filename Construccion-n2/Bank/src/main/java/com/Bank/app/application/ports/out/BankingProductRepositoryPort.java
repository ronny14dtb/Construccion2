package main.java.com.Bank.app.application.ports.out;

import com.Bank.app.domain.model.BankProduct;
import java.util.Optional;

public interface BankingProductRepositoryPort {

    Optional<BankProduct> findByCode(String code);
}