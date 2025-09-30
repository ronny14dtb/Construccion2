package com.hospital.app.infrastructure.persistence.jpa;

import com.hospital.app.domain.model.EstadoFactura;
import com.hospital.app.infrastructure.persistence.entity.FacturaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FacturaSpringDataRepository extends JpaRepository<FacturaJpaEntity, Long> {
    List<FacturaJpaEntity> findByPacienteId(Long pacienteId);
    List<FacturaJpaEntity> findByEstado(EstadoFactura estado);
}