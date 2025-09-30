package com.hospital.app.application.dto;
import java.time.LocalDateTime;

public record DatosAgendamientoCita(Long pacienteId, Long medicoId, LocalDateTime fechaHora, String motivo) {}