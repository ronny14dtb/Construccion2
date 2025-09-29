package com.universidad.proyecto.gestionhospital.infrastructure.persistence.mapper;

import com.universidad.proyecto.gestionhospital.domain.model.Empleado;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.entity.EmpleadoEntity;

public class EmpleadoMapper {

    public static Empleado toDomain(EmpleadoEntity entity) {
        return Empleado.builder()
                       .id(entity.getId())
                       .nombre(entity.getNombre())
                       .rol(entity.getRol())
                       .edad(entity.getEdad())
                       .build();
    }

    public static EmpleadoEntity toEntity(Empleado empleado) {
        return EmpleadoEntity.builder()
                             .id(empleado.getId())
                             .nombre(empleado.getNombre())
                             .rol(empleado.getRol())
                             .edad(empleado.getEdad())
                             .build();
    }
}
