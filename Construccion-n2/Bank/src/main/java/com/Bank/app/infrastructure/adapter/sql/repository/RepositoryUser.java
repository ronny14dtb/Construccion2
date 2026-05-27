package com.Bank.app.domain.infrastructure.adapter.sql.repository;
import com.Bank.app.domain.model.User;
import java.util.Optional;

public interface RepositoryUser {
    Optional<User> findByUsername(String username);
    void save(User user);
}