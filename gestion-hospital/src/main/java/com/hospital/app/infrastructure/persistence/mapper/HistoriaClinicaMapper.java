package com.hospital.app.infrastructure.persistence.mapper;

import com.hospital.app.domain.model.HistoriaClinica;
import com.hospital.app.infrastructure.persistence.entity.HistoriaClinicaJpaEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PacienteMapper.class, RegistroClinicoMapper.class})
public interface HistoriaClinicaMapper {

    HistoriaClinica toDomain(HistoriaClinicaJpaEntity entity);

    HistoriaClinicaJpaEntity toJpaEntity(HistoriaClinica domain);

}