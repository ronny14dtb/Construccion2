package com.universidad.proyecto.gestionhospital.controller;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.usecase.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final RegistrarPacienteUseCase registrarPaciente;
    private final ActualizarPacienteUseCase actualizarPaciente;
    private final EliminarPacienteUseCase eliminarPaciente;
    private final ListarPacientesUseCase listarPacientes;
    private final BuscarPacientePorIdUseCase buscarPacientePorId;
    private final AsignarMedicoAPacienteUseCase asignarMedicoAPaciente;

    public PacienteController(RegistrarPacienteUseCase registrarPaciente,
                              ActualizarPacienteUseCase actualizarPaciente,
                              EliminarPacienteUseCase eliminarPaciente,
                              ListarPacientesUseCase listarPacientes,
                              BuscarPacientePorIdUseCase buscarPacientePorId,
                              AsignarMedicoAPacienteUseCase asignarMedicoAPaciente) {
        this.registrarPaciente = registrarPaciente;
        this.actualizarPaciente = actualizarPaciente;
        this.eliminarPaciente = eliminarPaciente;
        this.listarPacientes = listarPacientes;
        this.buscarPacientePorId = buscarPacientePorId;
        this.asignarMedicoAPaciente = asignarMedicoAPaciente;
    }

    @PostMapping
    public Paciente registrar(@RequestBody Paciente paciente) {
        return registrarPaciente.ejecutar(paciente);
    }

    @PutMapping("/{id}")
    public Paciente actualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        paciente.setId(id);
        return actualizarPaciente.ejecutar(paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        eliminarPaciente.ejecutar(id);
    }

    @GetMapping
    public List<Paciente> listar() {
        return listarPacientes.ejecutar();
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Long id) {
        return buscarPacientePorId.ejecutar(id);
    }

    @PostMapping("/{idPaciente}/medico/{idMedico}")
    public Paciente asignarMedico(@PathVariable Long idPaciente, @PathVariable Long idMedico) {
        return asignarMedicoAPaciente.ejecutar(idPaciente, idMedico);
    }
}
