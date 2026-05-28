package com.Bank.app.infrastructure.adapter.sql.repository;

import com.Bank.app.infrastructure.adapter.sql.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional; 

@Repository
public interface BankAccountJpaRepository extends JpaRepository<BankAccountEntity, String> {
    
    List<BankAccountEntity> findByIdTitular(String idTitular);
    
   
    Optional<BankAccountEntity> findByNumeroCuenta(String numeroCuenta);
}