package ar.edu.unju.fi.poo.model;
import java.util.ArrayList;
import java.util.List;

public class ManageProducto {
	private List<Producto> productos;
	
	public ManageProducto() {
		productos = new ArrayList<>();
		
		productos.add(new Producto("P001", "Mouse", 10000, true));
        productos.add(new Producto("P002", "Teclado", 15000, true));
        productos.add(new Producto("P003", "Monitor", 80000, true));
        productos.add(new Producto("P004", "Auriculares", 25000, true));
        productos.add(new Producto("P005", "Webcam", 30000, true));
		
	}
	public Producto buscarPorCodigo(String codigo) {

        for (Producto p : productos) {

            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }

        return null;
    }

    public void listarProductos() {

        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
	
	
