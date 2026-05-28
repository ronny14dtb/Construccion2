package com.Bank.app.application.dto;
import java.math.BigDecimal;

public class BankAccountRequest {
    private String idTitular; 
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private String moneda;

    public String getIdTitular() { return idTitular; }
    public String getTipoCuenta() { return tipoCuenta; }
    public BigDecimal getSaldoInicial() { return saldoInicial; }
    public String getMoneda() { return moneda; }
}