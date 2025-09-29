package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.domain.model.Enfermera;
import com.universidad.proyecto.gestionhospital.port.out.EnfermeraRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarEnfermerasUseCase {

    private final EnfermeraRepositoryPort enfermeraRepositoryPort;

    public ListarEnfermerasUseCase(EnfermeraRepositoryPort enfermeraRepositoryPort) {
        this.enfermeraRepositoryPort = enfermeraRepositoryPort;
    }

    public List<Enfermera> listar() {
        return enfermeraRepositoryPort.listarTodas();
    }
}
