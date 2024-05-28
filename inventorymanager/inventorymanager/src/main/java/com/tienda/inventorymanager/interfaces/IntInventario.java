package com.tienda.inventorymanager.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.inventorymanager.models.*;

@Repository
public interface IntInventario extends CrudRepository<InventoryItem, Long> {
    // Esta interfaz proporciona métodos CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad InventoryItem.
    // La interfaz CrudRepository ya define métodos como save(), findById(), findAll(), delete(), etc., que pueden ser utilizados para interactuar con la base de datos.
    // La clase InventoryItem representa los elementos del inventario y Long es el tipo de dato de su identificador único.
}