package com.Bank.app.infrastructure.adapter.sql.repository;

import com.Bank.app.infrastructure.adapter.sql.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositoryTransfer extends JpaRepository<TransferEntity, Long> {
    
    List<TransferEntity> findByCuentaOrigen(String cuentaOrigen);
}