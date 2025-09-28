package com.universidad.proyecto.gestionhospital.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
@Inheritance(strategy = InheritanceType.JOINED) 
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String cargo;
    private String documentoIdentidad;

    public Empleado() {}

    public Empleado(String nombre, String apellido, String cargo, String documentoIdentidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.documentoIdentidad = documentoIdentidad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getDocumentoIdentidad() { return documentoIdentidad; }
    public void setDocumentoIdentidad(String documentoIdentidad) { this.documentoIdentidad = documentoIdentidad; }
}
