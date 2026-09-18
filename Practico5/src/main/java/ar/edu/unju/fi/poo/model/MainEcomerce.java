package ar.edu.unju.fi.poo.model;

import java.util.Scanner;

public class MainEcomerce {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Instanciar el manager de productos
        ManageProducto manager = new ManageProducto();

        // Instanciar un usuario
        Usuario usuario = new Usuario(
                "U001",
                "Diego",
                "diego@email.com"
        );

        int opcion = 0;

        while (opcion != 7) {

            System.out.println();
            System.out.println("===== MENU ECOMMERCE =====");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Mostrar carrito");
            System.out.println("4. Mostrar importe total");
            System.out.println("5. Remover producto del carrito");
            System.out.println("6. Vaciar carrito");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println();
                    System.out.println("===== PRODUCTOS DISPONIBLES =====");

                    manager.listarProductos();

                    break;

                case 2:

                    System.out.println();
                    System.out.print("Ingrese el codigo del producto: ");

                    String codigoAgregar = scanner.nextLine();

                    Producto productoAgregar =
                            manager.buscarPorCodigo(codigoAgregar);

                    if (productoAgregar != null && productoAgregar.getActivo()) {

                        System.out.print("Ingrese la cantidad: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();

                        if (cantidad > 0) {

                            usuario.agregarAlCarrito(
                                    productoAgregar,
                                    cantidad
                            );

                            System.out.println(
                                    "Producto agregado al carrito."
                            );

                        } else {

                            System.out.println(
                                    "La cantidad debe ser mayor a 0."
                            );
                        }

                    } else {

                        System.out.println(
                                "Producto no encontrado o inactivo."
                        );
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("===== CARRITO =====");

                    usuario.mostrarCarrito();

                    break;

                case 4:

                    System.out.println();
                    System.out.println("===== IMPORTE TOTAL =====");

                    System.out.println(
                            "Total: $" + usuario.verTotalCarrito()
                    );

                    break;

                case 5:

                    System.out.println();
                    System.out.print(
                            "Ingrese el codigo del producto que desea remover: "
                    );

                    String codigoRemover = scanner.nextLine();

                    Producto productoRemover =
                            manager.buscarPorCodigo(codigoRemover);

                    if (productoRemover != null) {

                        usuario.removerDelCarrito(productoRemover);

                        System.out.println(
                                "Producto removido del carrito."
                        );

                    } else {

                        System.out.println(
                                "Producto no encontrado."
                        );
                    }

                    break;

                case 6:

                    System.out.println();
                    System.out.println("===== VACIAR CARRITO =====");

                    usuario.getCarrito().vaciar();

                    System.out.println(
                            "El carrito fue vaciado."
                    );

                    break;

                case 7:

                    System.out.println();
                    System.out.println(
                            "Fin del programa."
                    );

                    break;

                default:

                    System.out.println();
                    System.out.println(
                            "Opcion incorrecta."
                    );
            }
        }

        scanner.close();
    }
}