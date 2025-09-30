package com.hospital.app.infrastructure.persistence.mapper;

import com.hospital.app.domain.model.Cita;
import com.hospital.app.infrastructure.persistence.entity.CitaJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PacienteMapper.class, MedicoMapper.class})
public interface CitaMapper {

    Cita toDomain(CitaJpaEntity entity);

    CitaJpaEntity toJpaEntity(Cita domain);

}