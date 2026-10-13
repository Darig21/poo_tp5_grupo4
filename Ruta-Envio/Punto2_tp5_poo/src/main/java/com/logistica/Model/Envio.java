package com.logistica.Model;

import com.logistica.Enums.EstadoEnvio;
import java.time.LocalDate; // <-- Importante
import java.util.ArrayList;
import java.util.List;

public class Envio {
    private String id;
    private String remitente;
    private String destinatario;
    private String direccionEntrega;
    private EstadoEnvio estado;
    private LocalDate fecha; // <-- Nuevo atributo de fecha
    private List<Paquete> paquetes;

    public Envio(String id, String remitente, String destinatario, String direccionEntrega) {
        this.id = id;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.direccionEntrega = direccionEntrega;
        this.estado = EstadoEnvio.GENERADO; // Estado por defecto
        this.fecha = LocalDate.now(); // Por defecto asigna la fecha actual
        this.paquetes = new ArrayList<>();
    }

    public void agregarPaquete(Paquete p) {
        this.paquetes.add(p);
    }

    public void despachar() {
        if (this.estado == EstadoEnvio.GENERADO || this.estado == EstadoEnvio.EN_ALMACEN) {
            this.estado = EstadoEnvio.EN_RUTA;
            System.out.println("Envío " + id + " despachado con éxito.");
        } else {
            System.out.println("No se puede despachar el envío " + id + " en estado: " + this.estado);
        }
    }

    public void devolver() {
        this.estado = EstadoEnvio.DEVUELTO;
        System.out.println("Envío " + id + " marcado como devuelto.");
    }

    public void mostrarInfo() {
        System.out.println("--- DETALLES DEL ENVÍO ---");
        System.out.println("ID: " + id);
        System.out.println("Remitente: " + remitente);
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Fecha: " + fecha); // <-- Mostrar fecha
        System.out.println("Estado: " + estado);
        System.out.println("Paquetes asociados (" + paquetes.size() + "):");
        for (Paquete p : paquetes) {
            System.out.println(" - " + p);
        }
        System.out.println("--------------------------");
    }

    public boolean tienePaquetes() {
        return !paquetes.isEmpty();
    }

    public double calcularPesoTotalEnvio() {
        return paquetes.stream().mapToDouble(Paquete::getPesoKg).sum();
    }

    // --- GETTERS y SETTERS necesarios ---
    public String getId() { return id; }
    
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public EstadoEnvio getEstado() { return estado; }
    public void setEstado(EstadoEnvio estado) { this.estado = estado; }  //actualizaciones de ruta 
}