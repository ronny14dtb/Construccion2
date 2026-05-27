package com.Bank.app.domain.infrastructure.adapter.sql.repository;
import com.Bank.app.domain.model.Loans;

public interface RepositoryLoans {
    void save(Loans loan);
    Loans findById(Long id);
}