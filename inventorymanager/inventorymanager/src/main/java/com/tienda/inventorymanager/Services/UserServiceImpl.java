package com.tienda.inventorymanager.Services;

import com.tienda.inventorymanager.repositories.UserRepository;
import com.tienda.inventorymanager.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // Indica que esta clase es un componente de servicio de Spring
public class UserServiceImpl implements UserService {

    @Autowired // Inyección de dependencia del repositorio UserRepository
    private UserRepository userRepository;

    @Autowired // Inyección de dependencia del codificador de contraseñas PasswordEncoder
    private PasswordEncoder passwordEncoder;

    // Método para guardar un usuario en la base de datos
    @Override
    public User save(User user) {
        // Codifica la contraseña del usuario antes de guardarla en la base de datos
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Guarda el usuario en la base de datos y devuelve el usuario guardado
        return userRepository.save(user);
    }

    // Método para validar las credenciales del usuario
    @Override
    public User validateUser(String username, String password) {
        // Busca un usuario por su nombre de usuario en la base de datos
        User user = userRepository.findByUsername(username);
        // Verifica si se encontró un usuario y si la contraseña proporcionada coincide con la contraseña almacenada codificada
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user; // Devuelve el usuario si las credenciales son válidas
        }
        return null; // Devuelve null si las credenciales son inválidas
    }
}
