package com.tienda.inventorymanager.Services;

import com.tienda.inventorymanager.models.User;

// Interfaz para el servicio de usuarios
public interface UserService {
    
    // Método para guardar un usuario
    User save(User user);
    
    // Método para validar las credenciales del usuario
    User validateUser(String username, String password);
}