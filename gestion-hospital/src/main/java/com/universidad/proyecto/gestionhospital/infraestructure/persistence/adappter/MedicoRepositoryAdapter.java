package com.universidad.proyecto.gestionhospital.infrastructure.persistence.adapter;

import com.universidad.proyecto.gestionhospital.application.port.out.MedicoRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.entity.MedicoEntity;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.jpa.MedicoJpaRepository;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.mapper.MedicoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicoRepositoryAdapter implements MedicoRepositoryPort {

    private final MedicoJpaRepository jpaRepository;

    public MedicoRepositoryAdapter(MedicoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Medico> findAll() {
        return jpaRepository.findAll().stream()
                            .map(MedicoMapper::toDomain)
                            .collect(Collectors.toList());
    }

    @Override
    public Medico save(Medico medico) {
        MedicoEntity entity = MedicoMapper.toEntity(medico);
        return MedicoMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
