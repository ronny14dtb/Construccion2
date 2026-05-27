package main.java.com.Bank.app.infrastructure.adapter.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuentas_bancarias")
@Getter
@Setter
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
}