package com.hospital.app.application.dto;

public record DatosCreacionMedico(
    String nombre,
    String apellido,
    String especialidad,
    String numeroLicencia
) {}