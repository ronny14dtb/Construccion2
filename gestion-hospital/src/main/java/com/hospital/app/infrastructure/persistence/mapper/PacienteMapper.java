package com.hospital.app.infrastructure.persistence.mapper;

import com.hospital.app.domain.model.Paciente;
import com.hospital.app.infrastructure.persistence.entity.PacienteJpaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    Paciente toDomain(PacienteJpaEntity entity);
    
    @InheritInverseConfiguration
    PacienteJpaEntity toJpaEntity(Paciente domain);
}