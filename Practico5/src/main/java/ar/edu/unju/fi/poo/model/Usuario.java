package ar.edu.unju.fi.poo.model;

public class Usuario {
	private String id;
	private String nombre;
	private String email;
	private CarritoCompras carrito;
	
	public Usuario(String id, String nombre, String email) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.carrito = new CarritoCompras(1);
	}
	
	public void agregarAlCarrito(Producto p, int cantidad) {
		carrito.agregar(p, cantidad);
	}
	
	public void removerDelCarrito(Producto p) {
		carrito.remover(p);
	}
	
	public double verTotalCarrito() {
		return carrito.total();
	}
	
	public void mostrarCarrito() {

        carrito.mostrarCarrito();
    }

    public CarritoCompras getCarrito() {

        return carrito;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}


