package main.java.com.Bank.app.infrastructure.adapter.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transferencias")
@Getter
@Setter
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transferencia")
    private Long id;

    @Column(name = "cuenta_origen", nullable = false, length = 50)
    private String cuentaOrigen;

    @Column(name = "cuenta_destino", nullable = false, length = 50)
    private String cuentaDestino;

    @Column(name = "monto", nullable = false, precision = 15, scale = 2)
    private BigDecimal monto;

    @Column(name = "fecha_transferencia", nullable = false)
    private LocalDateTime fechaTransferencia;

    @Column(name = "estado", nullable = false, length = 30)
    private String estado;
}