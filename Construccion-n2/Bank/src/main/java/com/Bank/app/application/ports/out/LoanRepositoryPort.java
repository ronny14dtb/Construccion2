package com.Bank.app.application.ports.out;

import com.Bank.app.domain.model.Loans;
import java.util.Optional;

public interface LoanRepositoryPort {
    Loans save(Loans loan);
    Optional<Loans> findById(Long id);
}