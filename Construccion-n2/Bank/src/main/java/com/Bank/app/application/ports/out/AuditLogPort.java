package com.Bank.app.application.ports.out;
import com.Bank.app.domain.model.OperationLog;

public interface AuditLogPort {
    void save(OperationLog log);
}