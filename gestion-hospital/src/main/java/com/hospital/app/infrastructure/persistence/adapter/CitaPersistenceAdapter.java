package com.hospital.app.infrastructure.persistence.adapter;

import com.hospital.app.domain.model.Cita;
import com.hospital.app.domain.repository.CitaRepository;
import com.hospital.app.infrastructure.persistence.jpa.CitaSpringDataRepository;
import com.hospital.app.infrastructure.persistence.mapper.CitaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component // <-- ¡Esta anotación es clave! Le dice a Spring que cree un bean de esta clase.
@RequiredArgsConstructor
public class CitaPersistenceAdapter implements CitaRepository {

    private final CitaSpringDataRepository springDataRepository;
    private final CitaMapper mapper;

    @Override
    public Cita save(Cita cita) {
        var jpaEntity = mapper.toJpaEntity(cita);
        var savedEntity = springDataRepository.save(jpaEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Cita> findById(Long id) {
        return springDataRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Cita> findByMedicoIdAndFechaHoraBetween(Long medicoId, LocalDateTime start, LocalDateTime end) {
        return springDataRepository.findByMedicoIdAndFechaHoraBetween(medicoId, start, end)
                .stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Cita> findByPacienteId(Long pacienteId) {
        return springDataRepository.findByPacienteId(pacienteId)
                .stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}