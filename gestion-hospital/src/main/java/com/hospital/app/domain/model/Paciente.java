package com.hospital.app.domain.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class Paciente {
    private Long id;
    private String nombre;
    private String apellido;
    private String documentoIdentidad;
    private LocalDate fechaNacimiento;
}