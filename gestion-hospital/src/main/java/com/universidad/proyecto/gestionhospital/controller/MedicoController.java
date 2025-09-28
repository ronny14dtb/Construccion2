package com.universidad.proyecto.gestionhospital.controller;

import com.universidad.proyecto.gestionhospital.domain.model.Medico;
import com.universidad.proyecto.gestionhospital.usecase.RegistrarMedicoUseCase;
import com.universidad.proyecto.gestionhospital.usecase.ListarMedicosPorEspecialidadUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final RegistrarMedicoUseCase registrarMedico;
    private final ListarMedicosPorEspecialidadUseCase listarPorEspecialidad;

    public MedicoController(RegistrarMedicoUseCase registrarMedico,
                            ListarMedicosPorEspecialidadUseCase listarPorEspecialidad) {
        this.registrarMedico = registrarMedico;
        this.listarPorEspecialidad = listarPorEspecialidad;
    }

    @PostMapping
    public Medico registrar(@RequestBody Medico medico) {
        return registrarMedico.ejecutar(medico);
    }

    @GetMapping("/especialidad/{especialidad}")
    public List<Medico> listarPorEspecialidad(@PathVariable String especialidad) {
        return listarPorEspecialidad.ejecutar(especialidad);
    }
}
