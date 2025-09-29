package com.universidad.proyecto.gestionhospital.infrastructure.persistence.adapter;

import com.universidad.proyecto.gestionhospital.application.port.out.EmpleadoRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Empleado;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.entity.EmpleadoEntity;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.jpa.EmpleadoJpaRepository;
import com.universidad.proyecto.gestionhospital.infrastructure.persistence.mapper.EmpleadoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmpleadoRepositoryAdapter implements EmpleadoRepositoryPort {

    private final EmpleadoJpaRepository jpaRepository;

    public EmpleadoRepositoryAdapter(EmpleadoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Empleado> findAll() {
        return jpaRepository.findAll().stream()
                            .map(EmpleadoMapper::toDomain)
                            .collect(Collectors.toList());
    }

    @Override
    public Empleado save(Empleado empleado) {
        EmpleadoEntity entity = EmpleadoMapper.toEntity(empleado);
        return EmpleadoMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
