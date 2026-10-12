
package com.logistica.Service;

import com.logistica.Model.Envio;
import com.logistica.Model.Vehiculo;
import java.util.ArrayList;
import java.util.List;

public class ManagerEnvios {

    private List<Envio> envios;
    private List<Vehiculo> vehiculos;
    private List<RutaDiaria> rutas;

    public ManagerEnvios() {
        this.envios = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.rutas = new ArrayList<>();
    }

    public void registrarEnvio(Envio e) {
        envios.add(e);
        System.out.println(
            "Envío registrado con éxito: " + e.getId()
        );
    }

    public void registrarVehiculo(Vehiculo v) {
        vehiculos.add(v);
        System.out.println(
            "Vehículo registrado con éxito: " + v.getPatente()
        );
    }

    public void registrarRuta(RutaDiaria ruta) {
        rutas.add(ruta);
    }

    public Envio buscarEnvio(String id) {
        return envios.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Obtener los envíos transportados por un vehículo
    public List<Envio> obtenerEnviosPorPatente(String patente) {

        List<Envio> resultado = new ArrayList<>();

        for (RutaDiaria ruta : rutas) {

            if (ruta.getVehiculo().getPatente()
                    .equalsIgnoreCase(patente)) {

                for (Envio envio : ruta.getEnvios()) {

                    if (!resultado.contains(envio)) {
                        resultado.add(envio);
                    }
                }
            }
        }

        return resultado;
    }
}
