package com.tienda.inventorymanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Anotación Lombok para generar automáticamente getters, setters, toString(), equals() y hashCode()
@Entity // Anotación para especificar que esta clase es una entidad JPA
@Table(name = "invent") // Nombre de la tabla en la base de datos
@NoArgsConstructor // Anotación Lombok para generar un constructor sin argumentos
@AllArgsConstructor // Anotación Lombok para generar un constructor con todos los argumentos
public class InventoryItem {
    @Id // Anotación para especificar la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de generación de identificador autoincremental
    private long id; // Identificador único del elemento del inventario
    private String name; // Nombre del elemento del inventario
    private String description; // Descripción del elemento del inventario
    private int cantidad; // Cantidad del elemento del inventario
    private String precio; // Precio del elemento del inventario
    private String ubicacion; // Ubicación del elemento del inventario
}