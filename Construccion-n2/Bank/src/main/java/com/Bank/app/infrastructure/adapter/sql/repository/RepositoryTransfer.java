package com.Bank.app.domain.infrastructure.adapter.sql.repository;

import com.Bank.app.domain.model.Transfer;
import java.util.List;

public interface RepositoryTransfer {
    void save(Transfer transfer);
    List<Transfer> findByOriginAccount(String accountNumber);
}