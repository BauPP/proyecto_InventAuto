package com.tienda.inventorymanager.Services;

import java.util.List;

import com.tienda.inventorymanager.models.InventoryItem;

// Interfaz para el servicio de elementos de inventario
public interface InventoryItemService {
    
    // Método para listar todos los elementos del inventario
    public List<InventoryItem> listar();
    
    // Método para obtener un elemento del inventario por su ID
    public InventoryItem listarId(int id);
    
    // Método para guardar un elemento del inventario
    public int save(InventoryItem p);
    
    // Método para eliminar un elemento del inventario por su ID
    public void delete(Long id);
}
