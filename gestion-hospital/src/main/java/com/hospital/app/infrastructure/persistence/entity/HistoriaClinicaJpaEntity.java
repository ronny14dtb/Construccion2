package com.hospital.app.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "historias_clinicas")
@Data
public class HistoriaClinicaJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private PacienteJpaEntity paciente;

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroClinicoJpaEntity> registros = new ArrayList<>();
}