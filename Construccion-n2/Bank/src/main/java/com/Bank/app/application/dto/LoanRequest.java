package com.Bank.app.application.dto;
import java.math.BigDecimal;

public class LoanRequest {
    private String userId;
    private BigDecimal requestedAmount;
    private int termMonths;

    private String tipoPrestamo; 
    private Double tasaInteres;
    private String cuentaDestinoDesembolso;

    public String getIdClienteSolicitante() { return userId; }
    public BigDecimal getMontoSolicitado() { return requestedAmount; }
    public int getPlazoMeses() { return termMonths; }
    

    public String getTipoPrestamo() { return tipoPrestamo; }
    public Double getTasaInteres() { return tasaInteres; }
    public String getCuentaDestinoDesembolso() { return cuentaDestinoDesembolso; }
}