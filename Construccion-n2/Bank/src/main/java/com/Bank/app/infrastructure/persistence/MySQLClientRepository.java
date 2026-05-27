package main.java.com.Bank.app.infrastructure.persistence;

import main.java.com.Bank.app.application.ports.out.ClientRepositoryPort;
import main.java.com.Bank.app.infrastructure.adapter.sql.repository.RepositoryUser;
import org.springframework.stereotype.Component;

@Component
public class MySQLClientRepository implements ClientRepositoryPort {

    private final RepositoryUser repositoryUser;

    public MySQLClientRepository(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    @Override
    public boolean existsByIdIdentificacion(String idIdentificacion) {
        return repositoryUser.existsByIdIdentificacion(idIdentificacion);
    }
}