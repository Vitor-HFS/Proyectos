package Practicas;

import java.util.Scanner;

public class GestionInventario {
    private static Inventario inventario = new Inventario();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> mostrarInventario();
                case 3 -> buscarProducto();
                case 4 -> eliminarProducto();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Gestión de Inventario ===");
        System.out.println("1. Agregar producto");
        System.out.println("2. Mostrar inventario");
        System.out.println("3. Buscar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();

        inventario.agregarProducto(new Producto(nombre, cantidad, precio));
    }

    private static void mostrarInventario() {
        inventario.mostrarInventario();
    }

    private static void buscarProducto() {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombreBusqueda = scanner.nextLine();

        Producto producto = inventario.buscarProducto(nombreBusqueda);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }

    private static void eliminarProducto() {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombreEliminar = scanner.nextLine();

        boolean eliminado = inventario.eliminarProducto(nombreEliminar);
        if (eliminado) {
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }
}