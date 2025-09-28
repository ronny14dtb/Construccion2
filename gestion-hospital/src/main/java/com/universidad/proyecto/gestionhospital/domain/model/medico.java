package com.universidad.proyecto.gestionhospital.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medicos")
public class Medico extends Empleado {

    private String especialidad;
    private String numeroLicencia;

    public Medico() {}

    public Medico(String nombre, String apellido, String cargo, String documentoIdentidad,
                  String especialidad, String numeroLicencia) {
        super(nombre, apellido, cargo, documentoIdentidad);
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
    }


    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getNumeroLicencia() { return numeroLicencia; }
    public void setNumeroLicencia(String numeroLicencia) { this.numeroLicencia = numeroLicencia; }
}
