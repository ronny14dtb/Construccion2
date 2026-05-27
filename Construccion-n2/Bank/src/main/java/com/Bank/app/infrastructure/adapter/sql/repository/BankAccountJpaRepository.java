package main.java.com.Bank.app.infrastructure.adapter.sql.repository;

import main.java.com.Bank.app.infrastructure.adapter.sql.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BankAccountJpaRepository extends JpaRepository<BankAccountEntity, String> {
    
    List<BankAccountEntity> findByIdTitular(String idTitular);
}