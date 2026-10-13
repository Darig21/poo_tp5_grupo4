package com.logistica;

import com.logistica.Model.Envio;
import com.logistica.Model.Paquete;
import com.logistica.Model.Vehiculo;
import com.logistica.Service.ManagerEnvios;
import com.logistica.Service.RutaDiaria;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainEnvios {
    public static void main(String[] args) {
        ManagerEnvios manager = new ManagerEnvios();

        // 1. Registrar Vehículos
        Vehiculo v1 = new Vehiculo("AA123BB", 50.0, 200.0);
        manager.registrarVehiculo(v1);

        // 2. Registrar Envíos y Paquetes
        Envio envio1 = new Envio("ENV-001", "Juan Pérez", "María Gómez", "Av. Siempre Viva 742");

        // CASO A: Intentar asignar ruta sin paquetes (Debe fallar)
        RutaDiaria rutaHoy = new RutaDiaria(LocalDate.now(), v1);
        rutaHoy.asignarEnvio(envio1);

        // Agregar paquetes válidos (Total: 20 kg)
        envio1.agregarPaquete(new Paquete("P01", "Caja de libros", 15.0, 30.0));
        envio1.agregarPaquete(new Paquete("P02", "Notebook", 5.0, 10.0));

        manager.registrarEnvio(envio1);

        // 3. Mostrar Información del Envío
        envio1.mostrarInfo();

        // CASO B: Asignar Ruta Diaria correctamente
        rutaHoy.asignarEnvio(envio1);

        // Despachamos el envío para que su estado sea EN_RUTA y tenga la fecha de hoy
        envio1.despachar();

        // ------------------------------------------------------------------
        // CONSULTA DE ENVÍOS EN RUTA POR FECHA (INGRESADA POR TECLADO)
        // ------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------------------------------------------------");
        System.out.print("Ingrese la fecha a consultar (Formato AAAA-MM-DD, ej: " + LocalDate.now() + "): ");
        String fechaInput = scanner.nextLine();

        try {
            LocalDate fechaBuscada = LocalDate.parse(fechaInput);
            manager.mostrarEnviosEnRutaPorFecha(fechaBuscada);
        } catch (DateTimeParseException e) {
            System.out.println("❌ Formato de fecha incorrecto. Utilice el formato AAAA-MM-DD.");
        } finally {
            scanner.close(); // cambio
        }
    }
}