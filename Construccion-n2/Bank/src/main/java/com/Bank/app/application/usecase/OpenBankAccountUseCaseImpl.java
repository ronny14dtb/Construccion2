package main.java.com.Bank.app.application.usecase;

import com.Bank.app.application.dto.BankAccountRequest;
import com.Bank.app.application.ports.in.OpenBankAccountUseCase;
import com.Bank.app.application.ports.out.BankAccountRepositoryPort;
import com.Bank.app.application.ports.out.BankingProductRepositoryPort;
import com.Bank.app.application.ports.out.ClientRepositoryPort;
import com.Bank.app.domain.exceptions.DomainException;
import com.Bank.app.domain.model.Bankaccount;

import java.util.UUID;

public class OpenBankAccountUseCaseImpl implements OpenBankAccountUseCase {

    private final BankAccountRepositoryPort accountRepositoryPort;
    private final ClientRepositoryPort clientRepositoryPort;
    private final BankingProductRepositoryPort productRepositoryPort;

    public OpenBankAccountUseCaseImpl(BankAccountRepositoryPort accountRepositoryPort, 
                                      ClientRepositoryPort clientRepositoryPort, 
                                      BankingProductRepositoryPort productRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
        this.clientRepositoryPort = clientRepositoryPort;
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Bankaccount execute(BankAccountRequest request) {

        if (!clientRepositoryPort.existsByIdentification(request.getIdTitular())) {
            throw new DomainException("El cliente con identificación " + request.getIdTitular() + " no existe.");
        }

   
        productRepositoryPort.findByCode(request.getTipoCuenta())
                .orElseThrow(() -> new DomainException("El tipo de cuenta '" + request.getTipoCuenta() + "' no es válido en el catálogo."));


        Bankaccount newAccount = new Bankaccount();

        newAccount.setNumeroCuenta("CTA-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        newAccount.setTipoCuenta(request.getTipoCuenta());
        newAccount.setIdTitular(request.getIdTitular());
        newAccount.setSaldoActual(request.getSaldoInicial() != null ? request.getSaldoInicial() : 0.0);
        newAccount.setMoneda(request.getMoneda() != null ? request.getMoneda() : "COP");
        newAccount.setEstadoCuenta("Activa");

        return accountRepositoryPort.save(newAccount);
    }
}