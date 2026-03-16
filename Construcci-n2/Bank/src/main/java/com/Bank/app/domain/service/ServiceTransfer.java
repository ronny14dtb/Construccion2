package com.Bank.app.domain.service;

import com.Bank.app.domain.model.Bankaccount;
import java.math.BigDecimal;

public class ServiceTransfer {
    public void ejecutarTransferenciaInterna(Bankaccount origen, Bankaccount destino, BigDecimal monto) throws Exception {
        origen.validarSaldo(monto);
        // Aquí restas a uno y sumas a otro
    }
}