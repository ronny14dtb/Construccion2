package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.application.port.in.ListarMedicosPorEspecialidadUseCase;
import com.universidad.proyecto.gestionhospital.port.out.MedicoRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListarMedicosPorEspecialidadService implements ListarMedicosPorEspecialidadUseCase {

    private final MedicoRepositoryPort medicoRepositoryPort;

    public ListarMedicosPorEspecialidadService(MedicoRepositoryPort medicoRepositoryPort) {
        this.medicoRepositoryPort = medicoRepositoryPort;
    }

    @Override
    public List<Medico> listarPorEspecialidad(String especialidad) {
        return medicoRepositoryPort.listarPorEspecialidad(especialidad);
    }
}
