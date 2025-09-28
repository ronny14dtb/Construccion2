package com.universidad.proyecto.gestionhospital.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.universidad.proyecto.gestionhospital.repository.EmpleadoRepository;
import com.universidad.proyecto.gestionhospital.domain.model.Empleado;

@Service
public class RecursosHumanosService {
    private final EmpleadoRepository empleadoRepository;

    public RecursosHumanosService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Optional<Empleado> buscarPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}
