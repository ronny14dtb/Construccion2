package com.Bank.app.infrastructure.adapter.nosql.repository;

import com.Bank.app.domain.model.OperationLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoAuditRepository extends MongoRepository<OperationLog, String> {

}