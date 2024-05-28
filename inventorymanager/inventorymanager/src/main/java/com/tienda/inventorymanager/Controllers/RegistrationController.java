package com.tienda.inventorymanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tienda.inventorymanager.Services.UserService;
import com.tienda.inventorymanager.models.User;

@Controller
public class RegistrationController {
    
    @Autowired
    private UserService userService; // Servicio de usuarios
    
    // Muestra el formulario de registro
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User()); // Agrega un nuevo objeto de usuario al modelo
        return "register"; // Muestra la página de registro
    }
    
    // Procesa la solicitud de registro de usuario
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        userService.save(user); // Guarda al usuario utilizando el servicio de usuarios
        redirectAttributes.addFlashAttribute("message", "Registro exitoso! Por favor, ingresa."); // Agrega un mensaje de éxito para mostrar después de la redirección
        return "redirect:/login"; // Redirige a la página de inicio de sesión después del registro exitoso
    }
}

