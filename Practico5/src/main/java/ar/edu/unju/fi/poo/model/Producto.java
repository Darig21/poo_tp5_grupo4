package ar.edu.unju.fi.poo.model;

public class Producto {
	
	private String codigo;
	private String nombre;
	private double precio;
	private boolean activo;
	
	public Producto(String codigo, String nombre, double precio, boolean activo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.activo = activo;
	
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void setActivo(boolean activo) {
		this.activo= activo;
	}
	
	@Override
	public String toString() {
		return codigo + " - " + nombre + 
				" - $" + precio + 
				(activo ? " [Activo]" : " [Inactivo]");
	}

}



