package com.universidad.proyecto.gestionhospital.infrastructure.persistence.mapper;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.entity.PacienteEntity;

public class PacienteMapper {

    public static Paciente toDomain(PacienteEntity entity) {
        return new Paciente(entity.getId(), entity.getNombre(), entity.getEdad());
    }

    public static PacienteEntity toEntity(Paciente paciente) {
        PacienteEntity entity = new PacienteEntity();
        entity.setId(paciente.getId());
        entity.setNombre(paciente.getNombre());
        entity.setEdad(paciente.getEdad());
        return entity;
    }
}
