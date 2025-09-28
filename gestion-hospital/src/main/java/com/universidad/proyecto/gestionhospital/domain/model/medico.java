package com.universidad.proyecto.gestionhospital.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medico {
    private String nombre;
    private String especialidad;
    private int experiencia; // años de experiencia
}
