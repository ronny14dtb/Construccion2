package com.hospital.app.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "registros_clinicos")
@Data
public class RegistroClinicoJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaRegistro;
    
    @Column(length = 1000)
    private String diagnostico;

    @Column(length = 1000)
    private String tratamiento;

    @Column(length = 2000)
    private String notas;

    @ManyToOne
    @JoinColumn(name = "historia_id")
    private HistoriaClinicaJpaEntity historiaClinica;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoJpaEntity medico;
}