package main.java.com.Bank.app.application.ports.out;

import com.Bank.app.domain.model.User;
import java.util.Optional;

public interface UserRepositoryPort {
    Optional<User> findById(Integer id);
    Optional<User> findByEmail(String email);
}