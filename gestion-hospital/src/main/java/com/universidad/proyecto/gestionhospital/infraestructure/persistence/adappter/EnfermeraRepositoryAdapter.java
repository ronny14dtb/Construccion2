package com.universidad.proyecto.gestionhospital.infrastructure.persistence.adapter;

import com.universidad.proyecto.gestionhospital.application.port.out.EnfermeraRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Enfermera;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.entity.EnfermeraEntity;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.jpa.EnfermeraJpaRepository;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.mapper.EnfermeraMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnfermeraRepositoryAdapter implements EnfermeraRepositoryPort {

    private final EnfermeraJpaRepository jpaRepository;

    public EnfermeraRepositoryAdapter(EnfermeraJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Enfermera> findAll() {
        return jpaRepository.findAll().stream()
                            .map(EnfermeraMapper::toDomain)
                            .collect(Collectors.toList());
    }

    @Override
    public Enfermera save(Enfermera enfermera) {
        EnfermeraEntity entity = EnfermeraMapper.toEntity(enfermera);
        return EnfermeraMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
