package com.hospital.app.infrastructure.persistence.entity;

import com.hospital.app.domain.model.EstadoFactura;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "facturas")
@Data
public class FacturaJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaEmision;
    private Double montoTotal;

    @Enumerated(EnumType.STRING)
    private EstadoFactura estado;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteJpaEntity paciente;
}