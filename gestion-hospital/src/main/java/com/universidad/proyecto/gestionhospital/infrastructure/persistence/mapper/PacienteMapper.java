package com.universidad.proyecto.gestionhospital.infrastructure.persistence.mapper;


import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.infraestructure.persistence.entity.PacienteEntity;

public class PacienteMapper {

    public static Paciente toDomain(PacienteEntity entity) {
        if (entity == null) return null;
        return new Paciente(
                entity.getId(),
                entity.getNombre(),
                entity.getEdad(),
                entity.getEnfermedad(),
                entity.getMedico() 
        );
    }

    public static PacienteEntity toEntity(Paciente paciente) {
        if (paciente == null) return null;
        PacienteEntity entity = new PacienteEntity();
        entity.setId(paciente.getId());
        entity.setNombre(paciente.getNombre());
        entity.setEdad(paciente.getEdad());
        entity.setEnfermedad(paciente.getEnfermedad());
        entity.setMedico(paciente.getMedico()); 
        return entity;
    }
}
