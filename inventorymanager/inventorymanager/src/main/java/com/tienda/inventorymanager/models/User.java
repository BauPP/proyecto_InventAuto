package com.tienda.inventorymanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data // Anotación Lombok para generar automáticamente getters, setters, toString(), equals() y hashCode()
@Entity // Anotación para especificar que esta clase es una entidad JPA
@Table(name = "USER_DETAILS") // Nombre de la tabla en la base de datos
@NoArgsConstructor // Anotación Lombok para generar un constructor sin argumentos
@AllArgsConstructor // Anotación Lombok para generar un constructor con todos los argumentos
public class User {
    @Id // Anotación para especificar la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de generación de identificador autoincremental
    private Long id; // Identificador único del usuario
    private String username; // Nombre de usuario
    private String password; // Contraseña del usuario
    private String email; // Correo electrónico del usuario
}