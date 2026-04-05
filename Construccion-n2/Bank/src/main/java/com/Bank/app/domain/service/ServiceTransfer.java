package com.Bank.app.domain.service;

import com.Bank.app.domain.model.Bankaccount;
import com.Bank.app.domain.model.vo.Money;
import com.Bank.app.domain.exceptions.DomainException;

public class ServiceTransfer {

    public void ejecutarTransferenciaInterna(Bankaccount origen, Bankaccount destino, Money monto) {
        origen.validarSaldo(monto);


        origen.withdraw(monto);
        destino.deposit(monto);
        

    }
}