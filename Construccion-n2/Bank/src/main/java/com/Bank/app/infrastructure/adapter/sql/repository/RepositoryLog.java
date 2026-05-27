package com.Bank.app.domain.infrastructure.adapter.sql.repository;
import com.Bank.app.domain.model.OperationLog;

public interface RepositoryLog {
    void log(OperationLog log);
}