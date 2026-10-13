package com.logistica.Model;

public class Paquete {
    private String codigo;
    private String descripcion;
    private double pesoKg;
    private double volumenDm3;

    public Paquete(String codigo, String descripcion, double pesoKg, double volumenDm3) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pesoKg = pesoKg;
        this.volumenDm3 = volumenDm3;
    }

    public double getPesoKg() { return pesoKg; }
    public double getVolumenDm3() { return volumenDm3; }

    @Override
    public String toString() {
        return "Paquete [" + codigo + ": " + descripcion + ", Peso: " + pesoKg + "kg, Vol: " + volumenDm3 + "dm3]";
    }
}