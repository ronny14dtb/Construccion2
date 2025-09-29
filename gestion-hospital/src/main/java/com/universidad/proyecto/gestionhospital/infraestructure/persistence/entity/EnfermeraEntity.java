package com.universidad.proyecto.gestionhospital.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enfermeras")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnfermeraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int edad;
}
