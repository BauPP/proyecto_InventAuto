package com.tienda.inventorymanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository; // Interfaz de Spring Data JPA para proporcionar métodos CRUD para entidades JPA
import org.springframework.stereotype.Repository; // Anotación para indicar que esta interfaz es un componente de repositorio de Spring

import com.tienda.inventorymanager.models.InventoryItem; // Importa la clase de modelo InventoryItem

@Repository // Anotación para indicar que esta interfaz es un componente de repositorio de Spring
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    // Extiende JpaRepository para obtener métodos CRUD básicos para la entidad InventoryItem
    
    // No hay necesidad de agregar métodos aquí para métodos CRUD básicos, ya que JpaRepository los proporciona automáticamente.
    
    // Sin embargo, puedes agregar métodos de consulta personalizados si es necesario.
}
