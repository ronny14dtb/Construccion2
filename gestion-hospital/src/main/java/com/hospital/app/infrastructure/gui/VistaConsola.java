package com.hospital.app.infrastructure.gui;

import com.hospital.app.application.dto.DatosCreacionPaciente;
import com.hospital.app.application.port.in.paciente.BuscarPacienteUseCase;
import com.hospital.app.application.port.in.paciente.RegistrarPacienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class VistaConsola implements CommandLineRunner {

    private final RegistrarPacienteUseCase registrarPacienteUseCase;
    private final BuscarPacienteUseCase buscarPacienteUseCase;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Registrar Nuevo Paciente");
            System.out.println("2. Buscar Paciente por ID");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    registrarNuevoPaciente(scanner);
                    break;
                case 2:
                    buscarPacientePorId(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void registrarNuevoPaciente(Scanner scanner) {
        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Documento: ");
            String documento = scanner.nextLine();
            System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
            LocalDate fecha = LocalDate.parse(scanner.nextLine());

            var datos = new DatosCreacionPaciente(nombre, apellido, documento, fecha);
            var pacienteCreado = registrarPacienteUseCase.registrarPaciente(datos);

            System.out.println("\n✅ ¡Paciente registrado con éxito! ID: " + pacienteCreado.getId());
        } catch (Exception e) {
            System.err.println("Error registrando paciente: " + e.getMessage());
        }
    }

    private void buscarPacientePorId(Scanner scanner) {
        try {
            System.out.print("Ingrese el ID del paciente: ");
            Long id = scanner.nextLong();
            scanner.nextLine();

            buscarPacienteUseCase.buscarPorId(id)
                    .ifPresentOrElse(
                        paciente -> System.out.println("\n Paciente encontrado: " + paciente),
                        () -> System.out.println("\n❌ No se encontró ningún paciente con el ID " + id)
                    );
        } catch (Exception e) {
            System.err.println("Error buscando paciente: " + e.getMessage());
        }
    }
}