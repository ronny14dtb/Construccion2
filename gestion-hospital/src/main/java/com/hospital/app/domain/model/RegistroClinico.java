package com.hospital.app.domain.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class RegistroClinico {
    private Long id;
    private LocalDateTime fechaRegistro;
    private String diagnostico;
    private String tratamiento;
    private String notas;
    private Medico medico;
}