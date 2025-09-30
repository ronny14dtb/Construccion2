package com.hospital.app.application.usecase.medico;

import com.hospital.app.application.dto.DatosCreacionMedico;
import com.hospital.app.application.port.in.medico.RegistrarMedicoUseCase;
import com.hospital.app.domain.model.Medico;
import com.hospital.app.domain.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarMedicoService implements RegistrarMedicoUseCase {
    private final MedicoRepository medicoRepository;

    @Override
    public Medico registrarMedico(DatosCreacionMedico datos) {
        Medico nuevoMedico = Medico.builder()
                .nombre(datos.nombre())
                .apellido(datos.apellido())
                .especialidad(datos.especialidad())
                .numeroLicencia(datos.numeroLicencia())
                .build();
        return medicoRepository.save(nuevoMedico);
    }
}