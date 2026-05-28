package com.Bank.app.infrastructure.adapter.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs") 
@Getter
@Setter
@NoArgsConstructor
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String usuario;
    private String accion;
    private LocalDateTime fecha;

    // Constructor simple
    public LogEntity(String usuario, String accion) {
        this.usuario = usuario;
        this.accion = accion;
        this.fecha = LocalDateTime.now();
    }
}