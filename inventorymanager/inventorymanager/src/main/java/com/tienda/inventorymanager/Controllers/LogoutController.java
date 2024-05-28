package com.tienda.inventorymanager.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {
    
    // Controlador encargado de manejar el cierre de sesión
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Obtiene la sesión actual, si existe
        if (session != null) {
            session.invalidate(); // Invalida la sesión actual (cierra sesión)
        }
        return "redirect:/login"; // Redirige a la página de inicio de sesión después de cerrar sesión
    }
}
