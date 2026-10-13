package com.logistica.Model;

public class Vehiculo {
    private String patente;
    private double capacidadPesoKg;
    private double capacidadVolumenDm3;

    public Vehiculo(String patente, double capacidadPesoKg, double capacidadVolumenDm3) {
        this.patente = patente;
        this.capacidadPesoKg = capacidadPesoKg;
        this.capacidadVolumenDm3 = capacidadVolumenDm3;
    }

    public double getCapacidadPesoKg() { return capacidadPesoKg; }
    public double getCapacidadVolumenDm3() { return capacidadVolumenDm3; }
    public String getPatente() { return patente; }
}