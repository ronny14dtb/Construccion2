package com.universidad.proyecto.gestionhospital.services;

import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import com.universidad.proyecto.gestionhospital.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> getAll() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> getById(Long id) {
        return medicoRepository.findById(id);
    }

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }

    public List<Medico> findByEspecialidad(String especialidad) {
        return medicoRepository.findByEspecialidad(especialidad);
    }
}
