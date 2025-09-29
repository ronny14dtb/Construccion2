package com.universidad.proyecto.gestionhospital.infrastructure.persistence.mapper;



import com.universidad.proyecto.gestionhospital.domain.model.Enfermera;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.entity.EnfermeraEntity;

public class EnfermeraMapper {

    public static Enfermera toDomain(EnfermeraEntity entity) {
        return Enfermera.builder()
                        .id(entity.getId())
                        .nombre(entity.getNombre())
                        .edad(entity.getEdad())
                        .build();
    }

    public static EnfermeraEntity toEntity(Enfermera enfermera) {
        return EnfermeraEntity.builder()
                              .id(enfermera.getId())
                              .nombre(enfermera.getNombre())
                              .edad(enfermera.getEdad())
                              .build();
    }
}
