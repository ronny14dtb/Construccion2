package com.Bank.app.infrastructure.persistence;

import com.Bank.app.application.ports.out.UserRepositoryPort;
import com.Bank.app.domain.model.User;
import com.Bank.app.infrastructure.adapter.sql.repository.RepositoryUser;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class MySQLUserRepository implements UserRepositoryPort {

    private final RepositoryUser jpaRepository;

    public MySQLUserRepository(RepositoryUser jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return jpaRepository.findById(id).map(entity -> {
            User user = new User();

            user.setId(entity.getIdUsuario()); 

            user.setEmail(entity.getCorreoElectronico());
            user.setRolSistema(entity.getRolSistema());
            return user;
        });
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return jpaRepository.findByCorreoElectronico(email).map(entity -> {
            User user = new User();
            user.setId(entity.getIdUsuario());
            user.setEmail(entity.getCorreoElectronico());
            user.setRolSistema(entity.getRolSistema());
            return user;
        });
    }
}