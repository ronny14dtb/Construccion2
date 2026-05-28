package com.Bank.app.infrastructure.adapter.sql.repository;

import com.Bank.app.infrastructure.adapter.sql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositoryUser extends JpaRepository<UserEntity, Integer> {
    

    boolean existsByIdIdentificacion(String idIdentificacion);
    Optional<UserEntity> findByIdIdentificacion(String idIdentificacion);
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByCorreoElectronico(String correoElectronico);
}