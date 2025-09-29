package com.universidad.proyecto.gestionhospital.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int edad;

    // Propiedad para enfermedad
    private String enfermedad;

    // Relación con médico (si un paciente tiene un médico)
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
}
