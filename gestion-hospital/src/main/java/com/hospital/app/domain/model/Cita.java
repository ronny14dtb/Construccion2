package com.hospital.app.domain.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class Cita {
    private Long id;
    private LocalDateTime fechaHora;
    private String motivoConsulta;
    private EstadoCita estado;
    private Paciente paciente;
    private Medico medico;
}