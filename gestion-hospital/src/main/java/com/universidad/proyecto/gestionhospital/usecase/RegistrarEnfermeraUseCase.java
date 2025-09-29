package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.application.port.in.RegistrarEnfermeraUseCase;
import com.universidad.proyecto.gestionhospital.port.out.EnfermeraRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Enfermera;
import org.springframework.stereotype.Service;

@Service
public class RegistrarEnfermeraService implements RegistrarEnfermeraUseCase {

    private final EnfermeraRepositoryPort enfermeraRepositoryPort;

    public RegistrarEnfermeraService(EnfermeraRepositoryPort enfermeraRepositoryPort) {
        this.enfermeraRepositoryPort = enfermeraRepositoryPort;
    }

    @Override
    public Enfermera registrar(Enfermera enfermera) {
        return enfermeraRepositoryPort.guardar(enfermera);
    }
}
