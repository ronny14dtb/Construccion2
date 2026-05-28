package com.Bank.app.infrastructure.adapter.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prestamos")
@Getter
@Setter
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Integer idPrestamo;

    @Column(name = "tipo_prestamo", nullable = false, length = 50)
    private String tipoPrestamo;

    @Column(name = "id_cliente_solicitante", nullable = false, length = 50)
    private String idClienteSolicitante;

    @Column(name = "monto_solicitado", nullable = false, precision = 15, scale = 2)
    private BigDecimal montoSolicitado;

    @Column(name = "monto_approved", precision = 15, scale = 2)
    private BigDecimal montoApproved;

    @Column(name = "tasa_interes", nullable = false, precision = 5, scale = 2)
    private BigDecimal tasaInteres;

    @Column(name = "plazo_meses", nullable = false)
    private Integer plazoMeses;

    @Column(name = "estado_prestamo", nullable = false, length = 40)
    private String estadoPrestamo;

    @Column(name = "fecha_aprobacion")
    private LocalDateTime fechaAprobacion;

    @Column(name = "fecha_desembolso")
    private LocalDateTime fechaDesembolso;

    @Column(name = "cuenta_destino_desembolso", nullable = false, length = 50)
    private String cuentaDestinoDesembolso;
}