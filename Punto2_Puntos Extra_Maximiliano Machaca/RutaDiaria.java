package com.logistica.Service;

import com.logistica.Model.Envio;
import com.logistica.Model.Vehiculo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RutaDiaria {
    private LocalDate fecha;
    private Vehiculo vehiculo;
    private List<Envio> envios;

    public RutaDiaria(LocalDate fecha, Vehiculo vehiculo) {
        this.fecha = fecha;
        this.vehiculo = vehiculo;
        this.envios = new ArrayList<>();
    }

    public boolean asignarEnvio(Envio envio) {
        if (!envio.tienePaquetes()) {
            System.out.println("Error: El envío " + envio.getId() + " no se puede asignar porque no tiene paquetes.");
            return false;
        }

        double pesoActualRuta = envios.stream().mapToDouble(Envio::calcularPesoTotalEnvio).sum();
        double pesoNuevoEnvio = envio.calcularPesoTotalEnvio();

        if (pesoActualRuta + pesoNuevoEnvio > vehiculo.getCapacidadPesoKg()) {
            System.out.println("Error: Se supera la capacidad de peso del vehículo (" + vehiculo.getPatente() + ").");
            return false;
        }

        envios.add(envio);
        envio.despachar(); // Cambio de estado automático
        System.out.println("Envío " + envio.getId() + " asignado correctamente a la ruta del vehículo " + vehiculo.getPatente());
        return true;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public List<Envio> getEnvios() {
        return envios;
    }
}