package org.suu.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

public class ProductoListener {

    @PrePersist
    public void prePersist(Producto producto) {
        System.out.println("Producto a ser persistido: " + producto);
    }

    @PostPersist
    public void postPersist(Producto producto) {
        System.out.println("Producto persistido: " + producto);
    }

    @PreUpdate
    public void preUpdate(Producto producto) {
        System.out.println("Producto a ser actualizado: " + producto);
    }

    @PostUpdate
    public void postUpdate(Producto producto) {
        System.out.println("Producto actualizado: " + producto);
    }

    @PreRemove
    public void preRemove(Producto producto) {
        System.out.println("Producto a ser eliminado: " + producto);
    }

    @PostRemove
    public void postRemove(Producto producto) {
        System.out.println("Producto eliminado: " + producto);
    }
}