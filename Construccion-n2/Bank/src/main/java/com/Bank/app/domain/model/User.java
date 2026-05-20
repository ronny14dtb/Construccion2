package com.Bank.app.domain.model;

import com.Bank.app.domain.constant.RolSistem;
import com.Bank.app.domain.constant.UserStatus;
import com.Bank.app.domain.model.vo.Email;

public abstract class User {
    private Long idUsuario;
    private String username;
    private String password;
    private Email correo;
    private RolSistem rol;
    private UserStatus estado;

 public RolSistem getRol() {
    return this.rol;
}

    public void setRol(RolSistem rol) {
        this.rol = rol;
    }
}