package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.application.port.in.RegistrarMedicoUseCase;
import com.universidad.proyecto.gestionhospital.port.out.MedicoRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import org.springframework.stereotype.Service;

@Service
public class RegistrarMedicoUseCase implements RegistrarMedicoUseCase { 

    private final MedicoRepositoryPort medicoRepositoryPort;

    public RegistrarMedicoUseCase(MedicoRepositoryPort medicoRepositoryPort) {
        this.medicoRepositoryPort = medicoRepositoryPort;
    }

    @Override
    public Medico registrar(Medico medico) {
        return medicoRepositoryPort.guardar(medico);
    }
}
