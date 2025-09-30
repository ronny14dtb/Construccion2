package com.hospital.app.application.dto;
import java.time.LocalDate;

public record DatosCreacionPaciente(String nombre, String apellido, String documentoIdentidad, LocalDate fechaNacimiento) {}