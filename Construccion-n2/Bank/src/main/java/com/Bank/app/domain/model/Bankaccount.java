package com.Bank.app.domain.model;

import com.Bank.app.domain.constant.StateAccount;
import com.Bank.app.domain.model.vo.Money;
import com.Bank.app.domain.exceptions.DomainException;

public class Bankaccount {
    private String numeroCuenta;
    private String tipoCuenta;
    private String idTitular;
    private Money saldoActual;
    private StateAccount estado;

    public StateAccount getEstado() {
        return this.estado;
    }

    public void setEstado(StateAccount estado) {
        this.estado = estado;
    }

    public void withdraw(Money amount) {
  
        if (this.saldoActual == null || this.saldoActual.getAmount().compareTo(amount.getAmount()) < 0) {
            throw new DomainException("Saldo insuficiente en la cuenta " + numeroCuenta);
        }
        this.saldoActual = this.saldoActual.subtract(amount);
    }

    public void deposit(Money amount) {
        if (this.saldoActual == null) {
            this.saldoActual = amount;
        } else {
            this.saldoActual = this.saldoActual.add(amount);
        }
    }

    public void validarSaldo(Money monto) {
        if (this.saldoActual == null || this.saldoActual.getAmount().compareTo(monto.getAmount()) < 0) {
            throw new DomainException("Saldo insuficiente en la cuenta " + numeroCuenta);
        }
    }
}