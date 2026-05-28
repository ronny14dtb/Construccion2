package com.Bank.app.application.dto;
import java.math.BigDecimal;

public class TransferRequest {
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private BigDecimal amount;
    private String idUsuarioCreador; // <--- AGREGADO


    public String getCuentaOrigen() { return sourceAccountNumber; }
    public String getCuentaDestino() { return destinationAccountNumber; }
    public BigDecimal getMonto() { return amount; }
    
  
    public String getIdUsuarioCreador() { return idUsuarioCreador; }

    public void setIdUsuarioCreador(String idUsuarioCreador) { this.idUsuarioCreador = idUsuarioCreador; }
}