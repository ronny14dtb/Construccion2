package com.universidad.proyecto.gestionhospital.services;

import com.universidad.proyecto.gestionhospital.domain.model.Empleado;
import com.universidad.proyecto.gestionhospital.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativoService {

    private final EmpleadoRepository empleadoRepository;

    public AdministrativoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> getById(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void delete(Long id) {
        empleadoRepository.deleteById(id);
    }
}
