package com.Bank.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationLog {
    private String tipoOperacion;
    private LocalDateTime fechaHoraOperacion;
    private Integer idUsuario;
    private String rolUsuario;
    private String idProductoAfectado;
    private Map<String, Object> datosDetalle;
}