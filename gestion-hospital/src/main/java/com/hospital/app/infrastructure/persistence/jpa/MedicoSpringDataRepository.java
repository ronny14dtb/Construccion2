package com.hospital.app.infrastructure.persistence.jpa;

import com.hospital.app.infrastructure.persistence.entity.MedicoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicoSpringDataRepository extends JpaRepository<MedicoJpaEntity, Long> {
    List<MedicoJpaEntity> findByEspecialidad(String especialidad);
}