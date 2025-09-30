package com.hospital.app.application.dto;

public record DatosNuevoRegistro(
    Long medicoId,
    String diagnostico,
    String tratamiento,
    String notas
) {}