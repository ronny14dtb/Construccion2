package com.hospital.app.infrastructure.persistence.entity;

import com.hospital.app.domain.model.EstadoCita;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Data
public class CitaJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHora;
    private String motivoConsulta;

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteJpaEntity paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoJpaEntity medico;
}