package com.Bank.app.domain.model;

import com.Bank.app.domain.constant.StateAccount;
import java.math.BigDecimal;

public class Bankaccount {
    private String numeroCuenta;
    private String tipoCuenta;
    private String idTitular;
    private BigDecimal saldoActual;
    private String moneda;
    private StateAccount estado;

    public void validarSaldo(BigDecimal monto) throws Exception {
        if (this.saldoActual.compareTo(monto) < 0) {
            throw new Exception("Saldo insuficiente en la cuenta " + numeroCuenta);
        }
    }
}