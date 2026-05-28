package com.Bank.app.infrastructure.adapter.sql.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuentas_bancarias")
public class BankAccountEntity {

    @Id
    @Column(name = "numero_cuenta", length = 50)
    private String numeroCuenta;

    @Column(name = "tipo_cuenta", nullable = false, length = 50)
    private String tipoCuenta;

    @Column(name = "id_titular", nullable = false, length = 50)
    private String idTitular;

    @Column(name = "saldo_actual", nullable = false, precision = 15, scale = 2)
    private BigDecimal saldoActual;

    @Column(name = "moneda", nullable = false, length = 10)
    private String moneda;

    @Column(name = "estado_cuenta", nullable = false, length = 30)
    private String estadoCuenta;

    @Column(name = "fecha_apertura", nullable = false)
    private LocalDateTime fechaApertura;

    // --- CONSTRUCTORES ---
    public BankAccountEntity() {}

    public BankAccountEntity(String numeroCuenta, String tipoCuenta, String idTitular, 
                             BigDecimal saldoActual, String moneda, String estadoCuenta, 
                             LocalDateTime fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.idTitular = idTitular;
        this.saldoActual = saldoActual;
        this.moneda = moneda;
        this.estadoCuenta = estadoCuenta;
        this.fechaApertura = fechaApertura;
    }

    // --- GETTERS ---
    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTipoCuenta() { return tipoCuenta; }
    public String getIdTitular() { return idTitular; }
    public BigDecimal getSaldoActual() { return saldoActual; }
    public String getMoneda() { return moneda; }
    public String getEstadoCuenta() { return estadoCuenta; }
    public LocalDateTime getFechaApertura() { return fechaApertura; }

    // --- SETTERS ---
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
    public void setTipoCuenta(String tipoCuenta) { this.tipoCuenta = tipoCuenta; }
    public void setIdTitular(String idTitular) { this.idTitular = idTitular; }
    public void setSaldoActual(BigDecimal saldoActual) { this.saldoActual = saldoActual; }
    public void setMoneda(String moneda) { this.moneda = moneda; }
    public void setEstadoCuenta(String estadoCuenta) { this.estadoCuenta = estadoCuenta; }
    public void setFechaApertura(LocalDateTime fechaApertura) { this.fechaApertura = fechaApertura; }
}