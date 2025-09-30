package com.hospital.app.infrastructure.persistence.mapper;

import com.hospital.app.domain.model.RegistroClinico;
import com.hospital.app.infrastructure.persistence.entity.RegistroClinicoJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MedicoMapper.class})
public interface RegistroClinicoMapper {

    RegistroClinico toDomain(RegistroClinicoJpaEntity entity);
    
    RegistroClinicoJpaEntity toJpaEntity(RegistroClinico domain);

}