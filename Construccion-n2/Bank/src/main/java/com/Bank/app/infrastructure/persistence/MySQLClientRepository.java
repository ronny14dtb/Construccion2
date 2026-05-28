package com.Bank.app.infrastructure.persistence;

import com.Bank.app.application.ports.out.ClientRepositoryPort;
import com.Bank.app.infrastructure.adapter.sql.repository.RepositoryUser;
import com.Bank.app.domain.model.ClientPerson;
import com.Bank.app.domain.model.ClientCompany;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class MySQLClientRepository implements ClientRepositoryPort {

    private final RepositoryUser repositoryUser;

    public MySQLClientRepository(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    @Override
    public boolean existsByIdentification(String id) {
        return repositoryUser.existsById(Integer.valueOf(id)); 
    }

    @Override
    public Optional<ClientPerson> findPersonById(String id) {

        return Optional.empty();
    }

    @Override
    public Optional<ClientCompany> findCompanyById(String id) {
        return Optional.empty();
    }
}