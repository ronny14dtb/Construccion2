package com.Bank.app.infrastructure.adapter.nosql.repository;

import com.Bank.app.domain.model.OperationLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoAuditRepository extends MongoRepository<OperationLog, String> {

}