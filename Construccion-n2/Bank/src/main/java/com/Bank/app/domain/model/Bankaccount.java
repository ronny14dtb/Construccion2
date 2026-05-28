package com.Bank.app.domain.model;

import com.Bank.app.domain.constant.StateAccount;
import com.Bank.app.domain.model.vo.Money;
import com.Bank.app.domain.exceptions.DomainException;

public class Bankaccount {

    private String moneda; 
    private String numeroCuenta;
    private String tipoCuenta;
    private String idTitular;
    private Money saldoActual;
    private StateAccount estado;

    public Bankaccount() {
    }

    public Bankaccount(String numeroCuenta, String tipoCuenta, String idTitular, Money saldoActual,
                       StateAccount estado) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.idTitular = idTitular;
        this.saldoActual = saldoActual;
        this.estado = estado;
        this.moneda = "COP"; 
    }


    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMoneda() {
        return this.moneda != null ? this.moneda : "COP";
    }


    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public String getTipoCuenta() { return tipoCuenta; }
    public void setTipoCuenta(String tipoCuenta) { this.tipoCuenta = tipoCuenta; }

    public String getIdTitular() { return idTitular; }
    public void setIdTitular(String idTitular) { this.idTitular = idTitular; }

    public Money getSaldoActual() { return saldoActual; }
    public void setSaldoActual(Money saldoActual) { this.saldoActual = saldoActual; }

    public StateAccount getEstado() { return this.estado; }
    public void setEstado(StateAccount estado) { this.estado = estado; }

    public String getEstadoCuenta() { return this.estado != null ? this.estado.name() : null; }
    public void setEstadoCuenta(String estadoCuenta) {
        if (estadoCuenta != null) {
            this.estado = StateAccount.valueOf(estadoCuenta.toUpperCase());
        }
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