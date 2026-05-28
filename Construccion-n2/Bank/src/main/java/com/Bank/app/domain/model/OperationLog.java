package com.Bank.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document; 
import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bitacora_operaciones") 
public class OperationLog {
    
    @Id 
    private String idBitacora; 
    
    private String tipoOperacion;
    private LocalDateTime fechaHoraOperacion;
    private Integer idUsuario;
    private String rolUsuario;
    private String idProductoAfectado;
    private Map<String, Object> datosDetalle;
}