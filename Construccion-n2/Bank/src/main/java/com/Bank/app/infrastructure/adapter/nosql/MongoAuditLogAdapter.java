package com.Bank.app.infrastructure.adapter.nosql;

import com.Bank.app.domain.model.OperationLog;
import org.springframework.stereotype.Service;
import com.Bank.app.infrastructure.adapter.nosql.repository.MongoAuditRepository;
import com.Bank.app.application.ports.out.AuditLogPort;

@Service

public class MongoAuditLogAdapter implements AuditLogPort {
    private final MongoAuditRepository mongoRepository;

    public MongoAuditLogAdapter(MongoAuditRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public void save(OperationLog log) {
        mongoRepository.save(log);
    }
}

