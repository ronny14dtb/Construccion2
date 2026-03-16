package com.Bank.app.domain.repository;

import com.Bank.app.domain.model.Loans;

public interface RepositoryLoans {
    void save(Loans loan);
    Loans findById(Long id);
}