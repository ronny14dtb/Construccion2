package com.Bank.app.infrastructure.adapter.sql.repository;

import com.Bank.app.infrastructure.adapter.sql.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositoryLoans extends JpaRepository<LoanEntity, Integer> {
    
    List<LoanEntity> findByIdClienteSolicitante(String idClienteSolicitante);
}