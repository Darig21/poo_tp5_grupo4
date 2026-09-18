package com.logistica;

import com.logistica.Model.Envio;
import com.logistica.Model.Paquete;
import com.logistica.Model.Vehiculo;
import com.logistica.Service.ManagerEnvios;
import com.logistica.Service.RutaDiaria;
import java.time.LocalDate;

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

        // CASO B: Asignar Ruta Diaria correctamente (20kg <= 50kg)
        rutaHoy.asignarEnvio(envio1);

        // CASO C: Demostración de Exceso de Capacidad de Peso

        System.out.println("\n--- PRUEBA DE LÍMITE DE CAPACIDAD ---");
        Envio envio2 = new Envio("ENV-002", "Carlos López", "Ana Torres", "Calle Falsa 123");
        // Este paquete pesa 60kg, lo cual supera los 50kg permitidos por el vehículo v1
        envio2.agregarPaquete(new Paquete("P03", "Motor industrial", 60.0, 120.0));

        manager.registrarEnvio(envio2);

        // Esto debería arrojar un mensaje de error por superar la capacidad del vehículo
        rutaHoy.asignarEnvio(envio2);

        // CASO D: Probar cambio de estado (Devolución)
        System.out.println("\n--- PRUEBA DE ESTADO (DEVOLUCIÓN) ---");
        envio1.devolver();
        envio1.mostrarInfo();
    }
}