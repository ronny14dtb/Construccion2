package com.hospital.app.infrastructure.persistence.mapper;

import com.hospital.app.domain.model.Factura;
import com.hospital.app.infrastructure.persistence.entity.FacturaJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PacienteMapper.class})
public interface FacturaMapper {
    Factura toDomain(FacturaJpaEntity entity);
    FacturaJpaEntity toJpaEntity(Factura domain);
}