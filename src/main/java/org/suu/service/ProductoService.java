package org.suu.service;

import org.suu.entity.Producto;
import org.suu.repository.ProductoRepository;

import java.util.List;

public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService() {
        this.repository = new ProductoRepository();
    }

    public void crearProducto(Producto producto) {
        repository.crear(producto);
    }

    public Producto obtenerProducto(Long id) {
        return repository.leer(id);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return repository.leerTodos();
    }

    public void actualizarProducto(Producto producto) {
        repository.actualizar(producto);
    }

    public void eliminarProducto(Long id) {
        repository.eliminar(id);
    }

    public void cerrar() {
        repository.cerrar();
    }
}