package com.hospital.app.infrastructure.persistence.mapper;

import com.hospital.app.domain.model.Medico;
import com.hospital.app.infrastructure.persistence.entity.MedicoJpaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    Medico toDomain(MedicoJpaEntity entity);

    @InheritInverseConfiguration
    MedicoJpaEntity toJpaEntity(Medico domain);
}