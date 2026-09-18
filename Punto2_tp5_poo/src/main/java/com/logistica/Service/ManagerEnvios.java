package com.logistica.Service;

import com.logistica.Model.Envio;
import com.logistica.Model.Vehiculo;
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
}