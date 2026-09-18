package ar.edu.unju.fi.poo.model;

import java.util.ArrayList;
import java.util.List;


public class CarritoCompras {
	
	private int id;
	private List<ItemCarrito> items;
	
	public CarritoCompras(int id) {
		this.id = id;
		this.items = new ArrayList<>();
	}
	
	public void agregar(Producto p, int cantidad) {
		
		for(ItemCarrito item : items) {
			if(item.getProducto().getCodigo().equals(p.getCodigo())) {
				item.setCantidad(item.getCantidad() + cantidad);
				return;
			}
		}
		
		int nuevoId = items.size() + 1;
        ItemCarrito nuevoItem = new ItemCarrito(nuevoId, p, cantidad);

        items.add(nuevoItem);
	}
	
	public void remover(Producto p) {

        items.removeIf(item ->
            item.getProducto().getCodigo().equals(p.getCodigo())
        );
    }

    public double total() {

        double total = 0;

        for (ItemCarrito item : items) {
            total += item.subTotal();
        }

        return total;
    }

    public void vaciar() {
        items.clear();
    }

    public void mostrarCarrito() {

        System.out.println("----- CARRITO -----");

        if (items.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {

            for (ItemCarrito item : items) {
                System.out.println(item);
            }
        }

        System.out.println("-------------------");
        System.out.println("Total: $" + total());
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public int getId() {
        return id;
    }
}



