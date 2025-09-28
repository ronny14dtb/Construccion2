package com.universidad.proyecto.gestionhospital.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "enfermeras")
public class Enfermera extends Empleado {

    private String turno; 
    private String area;  


    public Enfermera() {}

    public Enfermera(String nombre, String apellido, String cargo, String documentoIdentidad,
                     String turno, String area) {
        super(nombre, apellido, cargo, documentoIdentidad);
        this.turno = turno;
        this.area = area;
    }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
}
