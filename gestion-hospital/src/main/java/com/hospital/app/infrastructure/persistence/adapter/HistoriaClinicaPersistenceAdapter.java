package com.hospital.app.infrastructure.persistence.adapter;

import com.hospital.app.domain.model.HistoriaClinica;
import com.hospital.app.domain.repository.HistoriaClinicaRepository;
import com.hospital.app.infrastructure.persistence.jpa.HistoriaClinicaSpringDataRepository;
import com.hospital.app.infrastructure.persistence.mapper.HistoriaClinicaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HistoriaClinicaPersistenceAdapter implements HistoriaClinicaRepository {

    private final HistoriaClinicaSpringDataRepository springDataRepository;
    private final HistoriaClinicaMapper mapper;

    @Override
    public HistoriaClinica save(HistoriaClinica historiaClinica) {
        var jpaEntity = mapper.toJpaEntity(historiaClinica);
        var savedEntity = springDataRepository.save(jpaEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<HistoriaClinica> findByPacienteId(Long pacienteId) {
        return springDataRepository.findByPacienteId(pacienteId).map(mapper::toDomain);
    }
}