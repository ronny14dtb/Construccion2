package com.hospital.app.domain.model;

import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class HistoriaClinica {
    private Long id;
    private Paciente paciente;
    @Builder.Default
    private List<RegistroClinico> registros = new ArrayList<>();
}