package com.tienda.inventorymanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tienda.inventorymanager.models.User;

@Repository // Anotación para indicar que esta interfaz es un componente de repositorio de Spring
public interface UserRepository extends JpaRepository<User, Long> {
    // Extiende JpaRepository para obtener métodos CRUD básicos para la entidad User
    
    // Método para encontrar un usuario por su nombre de usuario
    User findByUsername(String username);
    
    // Método para encontrar un usuario por su nombre de usuario y contraseña
    User findByUsernameAndPassword(String username, String password);
}