package com.universidad.proyecto.gestionhospital.infrastructure.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import com.universidad.proyecto.gestionhospital.domain.model.Paciente;
import com.universidad.proyecto.gestionhospital.application.port.in.ListarPacientesUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;

@SpringBootApplication
public class PacienteFrame {

    @Autowired
    private ListarPacientesUseCase listarPacientesUseCase;

    public static void main(String[] args) {
        var context = new SpringApplication(PacienteFrame.class);
        context.setWebApplicationType(WebApplicationType.NONE);
        var appContext = context.run(args);

        PacienteFrame app = appContext.getBean(PacienteFrame.class);
        app.mostrarVentana();
    }

    public void mostrarVentana() {
        JFrame frame = new JFrame("Pacientes del Hospital");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new BorderLayout());

        List<Paciente> pacientes = listarPacientesUseCase.listarPacientes(); // uso del UseCase

        StringBuilder sb = new StringBuilder();
        for (Paciente p : pacientes) {
            sb.append("ID: ").append(p.getId())
              .append(" | Nombre: ").append(p.getNombre())
              .append(" | Edad: ").append(p.getEdad())
              .append("\n");
        }

        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);

        panel.add(scroll, BorderLayout.CENTER);
        frame.add(panel);

        frame.setVisible(true);
    }
}
