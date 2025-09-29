package com.universidad.proyecto.gestionhospital.infrastructure.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import com.universidad.proyecto.gestionhospital.domain.model.Empleado;
import com.universidad.proyecto.gestionhospital.application.port.in.ListarEmpleadosUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;

@SpringBootApplication
public class EmpleadoFrame {

    @Autowired
    private ListarEmpleadosUseCase listarEmpleadosUseCase;

    public static void main(String[] args) {
        var context = new SpringApplication(EmpleadoFrame.class);
        context.setWebApplicationType(WebApplicationType.NONE);
        var appContext = context.run(args);

        EmpleadoFrame app = appContext.getBean(EmpleadoFrame.class);
        app.mostrarVentana();
    }

    public void mostrarVentana() {
        JFrame frame = new JFrame("Empleados del Hospital");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new BorderLayout());

        List<Empleado> empleados = listarEmpleadosUseCase.listarTodos();

        StringBuilder sb = new StringBuilder();
        for (Empleado emp : empleados) {
            sb.append("ID: ").append(emp.getId())
              .append(" | Nombre: ").append(emp.getNombre())
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
