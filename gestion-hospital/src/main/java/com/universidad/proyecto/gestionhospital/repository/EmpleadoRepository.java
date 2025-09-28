package com.universidad.proyecto.gestionhospital.repository;


import com.universidad.proyecto.gestionhospital.domain.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
