package main.java.com.Bank.app.infrastructure.adapter.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_identificacion", unique = true, nullable = false)
    private String idIdentificacion; 

    @Column(name = "id_relacionado")
    private String idRelacionado; 

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "correo_electronico", nullable = false)
    private String correoElectronico;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "rol_sistema", nullable = false)
    private String rolSistema; 

    @Column(name = "estado_usuario", nullable = false)
    private String estadoUsuario; 


    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
}