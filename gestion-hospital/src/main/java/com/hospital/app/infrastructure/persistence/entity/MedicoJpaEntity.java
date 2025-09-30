package com.hospital.app.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "medicos")
@Data
public class MedicoJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String especialidad;
    
    @Column(unique = true)
    private String numeroLicencia;
}