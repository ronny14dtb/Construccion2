package main.java.com.Bank.app.application.ports.out;

import com.Bank.app.domain.model.ClientCompany;
import com.Bank.app.domain.model.ClientPerson;
import java.util.Optional;

public interface ClientRepositoryPort {
    Optional<ClientPerson> findPersonById(String identification);
    Optional<ClientCompany> findCompanyById(String identification);
    boolean existsByIdentification(String identification); 
}