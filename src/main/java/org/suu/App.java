package org.suu;

import org.suu.entity.Producto;
import org.suu.service.ProductoService;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final ProductoService productoService = new ProductoService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- CRUD de Productos ---");
            System.out.println("1. Crear producto");
            System.out.println("2. Leer producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Listar todos los productos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> crearProducto();
                case 2 -> leerProducto();
                case 3 -> actualizarProducto();
                case 4 -> eliminarProducto();
                case 5 -> listarProductos();
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        }
        productoService.cerrar();
        scanner.close();
    }

    private static void crearProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del producto: ");
        BigDecimal precio = scanner.nextBigDecimal();
        System.out.print("Tipo del producto:");
        String tipo = scanner.next();

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setTipo(tipo);

        productoService.crearProducto(producto);
        System.out.println("Producto creado con éxito");
    }

    private static void leerProducto() {
        System.out.print("ID del producto: ");
        Long id = scanner.nextLong();
        Producto producto = productoService.obtenerProducto(id);
        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    private static void actualizarProducto() {
        System.out.print("ID del producto a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Producto producto = productoService.obtenerProducto(id);
        if (producto != null) {
            System.out.print("Nuevo nombre (deje en blanco para mantener el actual): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                producto.setNombre(nombre);
            }

            System.out.print("Nuevo precio (0 para mantener el actual): ");
            BigDecimal precio = scanner.nextBigDecimal();
            if (precio.compareTo(BigDecimal.ZERO) != 0) {
                producto.setPrecio(precio);
            }

            System.out.print("Nuevo tipo (deje en blanco para mantener el actual): ");
            String tipo = scanner.next();
            if (!tipo.isEmpty()) {
                producto.setTipo(tipo);
            }

            productoService.actualizarProducto(producto);
            System.out.println("Producto actualizado con éxito");
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    private static void eliminarProducto() {
        System.out.print("ID del producto a eliminar: ");
        Long id = scanner.nextLong();
        productoService.eliminarProducto(id);
        System.out.println("Producto eliminado con éxito");
    }

    private static void listarProductos() {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }
}