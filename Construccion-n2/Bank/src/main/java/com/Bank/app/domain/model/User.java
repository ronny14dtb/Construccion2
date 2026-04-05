package com.Bank.app.domain.model;


import com.Bank.app.domain.constant.RolSistem;

public abstract class User {
    private Long idUsuario;
    private String nombreCompleto;
    private String identificacion;
    private String correoElectronico;
    private String telefono;
    private String direccion;
    private RolSistem rol;
    private String estadoUsuario;
}