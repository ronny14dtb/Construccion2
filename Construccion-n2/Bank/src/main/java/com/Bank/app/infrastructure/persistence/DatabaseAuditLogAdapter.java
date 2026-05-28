package com.Bank.app.infrastructure.persistence;

import com.Bank.app.application.ports.out.AuditLogPort;
import com.Bank.app.domain.model.OperationLog;
import com.Bank.app.infrastructure.adapter.sql.entity.LogEntity;
import com.Bank.app.infrastructure.adapter.sql.repository.RepositoryLog;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseAuditLogAdapter implements AuditLogPort {

    private final RepositoryLog logRepository;

    public DatabaseAuditLogAdapter(RepositoryLog logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void save(OperationLog log) {
        LogEntity entity = new LogEntity();
        
        entity.setUsuario(log.getIdUsuario() != null ? log.getIdUsuario().toString() : "0");
        entity.setAccion(log.getTipoOperacion());
        
        logRepository.save(entity);
    }
}