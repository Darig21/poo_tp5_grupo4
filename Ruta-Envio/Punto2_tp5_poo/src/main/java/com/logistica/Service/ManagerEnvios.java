package com.logistica.Service;

import com.logistica.Model.Envio;
import com.logistica.Model.Vehiculo;
import com.logistica.Enums.EstadoEnvio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerEnvios {
    private List<Envio> envios;
    private List<Vehiculo> vehiculos;

    public ManagerEnvios() {
        this.envios = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }

    public void registrarEnvio(Envio e) {
        envios.add(e);
        System.out.println("Envío registrado con éxito: " + e.getId());
    }

    public void registrarVehiculo(Vehiculo v) {
        vehiculos.add(v);
        System.out.println("Vehículo registrado con éxito: " + v.getPatente());
    }

    public Envio buscarEnvio(String id) {
        return envios.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Obtiene y muestra los envíos que se encuentran EN RUTA para una fecha específica.
     */
    public void mostrarEnviosEnRutaPorFecha(LocalDate fechaBuscada) {
        System.out.println("\n=== CONSULTA DE ENVÍOS EN RUTA PARA LA FECHA: " + fechaBuscada + " ===");
        boolean encontrado = false;

        for (Envio e : envios) {
            if (e.getFecha() != null && e.getFecha().equals(fechaBuscada) && e.getEstado() == EstadoEnvio.EN_RUTA) {
                e.mostrarInfo();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron envíos en ruta para la fecha especificada.");
        }
    }
}