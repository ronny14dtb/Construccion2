package com.Bank.app.infrastructure.adapter.sql.repository;

import com.Bank.app.infrastructure.adapter.sql.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLog extends JpaRepository<LogEntity, Integer> {

}