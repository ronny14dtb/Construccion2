package com.Bank.app.domain.model;

import java.time.LocalDateTime;
import java.util.Map;

public record OperationLog(
    String idBitacora,
    String tipoOperacion,
    LocalDateTime fecha,
    Long idUsuario,
    Map<String, Object> detalles
) {}