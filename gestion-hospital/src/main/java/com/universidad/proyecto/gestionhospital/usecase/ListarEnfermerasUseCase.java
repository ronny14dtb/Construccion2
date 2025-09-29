package com.universidad.proyecto.gestionhospital.usecase;

import com.universidad.proyecto.gestionhospital.application.port.in.ListarEnfermerasUseCase;
import com.universidad.proyecto.gestionhospital.port.out.EnfermeraRepositoryPort;
import com.universidad.proyecto.gestionhospital.domain.model.Enfermera;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListarEnfermerasService implements ListarEnfermerasUseCase {

    private final EnfermeraRepositoryPort enfermeraRepositoryPort;

    public ListarEnfermerasService(EnfermeraRepositoryPort enfermeraRepositoryPort) {
        this.enfermeraRepositoryPort = enfermeraRepositoryPort;
    }

    @Override
    public List<Enfermera> listar() {
        return enfermeraRepositoryPort.listarTodas();
    }
}
