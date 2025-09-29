package com.universidad.proyecto.gestionhospital.infrastructure.persistence.mapper;


import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.entity.MedicoEntity;

public class MedicoMapper {

    public static Medico toDomain(MedicoEntity entity) {
        return Medico.builder()
                     .id(entity.getId())
                     .nombre(entity.getNombre())
                     .especialidad(entity.getEspecialidad())
                     .edad(entity.getEdad())
                     .build();
    }

    public static MedicoEntity toEntity(Medico medico) {
        return MedicoEntity.builder()
                           .id(medico.getId())
                           .nombre(medico.getNombre())
                           .especialidad(medico.getEspecialidad())
                           .edad(medico.getEdad())
                           .build();
    }
}
