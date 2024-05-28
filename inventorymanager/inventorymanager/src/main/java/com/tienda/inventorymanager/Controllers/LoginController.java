package com.tienda.inventorymanager.Controllers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.tienda.inventorymanager.models.InventoryItem;
import com.tienda.inventorymanager.Services.UserService;
import com.tienda.inventorymanager.models.User;
import com.tienda.inventorymanager.repositories.InventoryItemRepository;
import com.tienda.inventorymanager.Services.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService; // Servicio de usuarios

    @Autowired
    InventoryItemService service; // Servicio de elementos de inventario
    
    @Autowired
    private InventoryItemRepository inventoryitemrepository; // Repositorio para elementos de inventario

    // Maneja la solicitud raíz
    @GetMapping("/")
    public String handleRootRequest(HttpSession session, RedirectAttributes redirectAttributes) {
        User currentUser = (User) session.getAttribute("currentUser"); // Obtiene el usuario actual de la sesión
        if (Objects.nonNull(currentUser)) {
            return "redirect:/dashboard"; // Redirige al tablero de instrumentos si hay un usuario registrado
        } else {
            redirectAttributes.addFlashAttribute("error", "Por favor, inicia sesión.");
            return "redirect:/login"; // Redirige a la página de inicio de sesión con un mensaje de error si no hay un usuario registrado
        }
    }
    
    // Muestra la página de inicio de sesión
    @GetMapping("/login")
    public String showLoginPage(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser"); // Obtiene el usuario actual de la sesión
        if (Objects.nonNull(currentUser)) {
            return "redirect:/dashboard"; // Redirige al tablero de instrumentos si hay un usuario registrado
        }
        // Agrega un nuevo objeto usuario al modelo y muestra la página de inicio de sesión
        model.addAttribute("user", new User());
        return "login";
    }

    // Procesa la solicitud de inicio de sesión
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes, HttpSession session) {
        // Valida las credenciales del usuario
        User validUser = userService.validateUser(user.getUsername(), user.getPassword());
        if (Objects.nonNull(validUser)) {
            session.setAttribute("currentUser", validUser); // Establece el usuario actual en la sesión
            return "redirect:/dashboard"; // Redirige al tablero de instrumentos si las credenciales son válidas
        } else {
            redirectAttributes.addFlashAttribute("error", "Usuario o contraseña invalida. Por favor, intenta de nuevo.");
            return "redirect:/login"; // Redirige a la página de inicio de sesión con un mensaje de error si las credenciales son inválidas
        }
    }

    // Muestra el tablero de instrumentos
    @GetMapping("/dashboard")
    public String showDashboardPage(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        User currentUser = (User) session.getAttribute("currentUser"); // Obtiene el usuario actual de la sesión
        if (Objects.isNull(currentUser)) {
            redirectAttributes.addFlashAttribute("error", "No estás registrado. Por favor, inicia sesión.");
            return "redirect:/login"; // Redirige a la página de inicio de sesión con un mensaje de error si no hay un usuario registrado
        }
        // Obtiene todos los elementos de inventario y los agrega al modelo junto con el usuario actual, luego muestra el tablero de instrumentos
        List<InventoryItem> persona = inventoryitemrepository.findAll();
        model.addAttribute("inventoryItems", persona);
        model.addAttribute("user", currentUser);
        return "/dashboard";
    }
    
    // Agrega un nuevo elemento de inventario
    @GetMapping("/new")
    public String agregar(Model model) {
        model.addAttribute("persona", new InventoryItem());
        return "formulario";
    }

    // Guarda un elemento de inventario
    @PostMapping("/save")
    public String save(@Validated InventoryItem item, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formulario"; // Vuelve al formulario si hay errores de validación
        }
        inventoryitemrepository.save(item); // Guarda el elemento de inventario en el repositorio
        return "redirect:/dashboard"; // Redirige al tablero de instrumentos después de guardar
    }
    
    // Muestra el formulario de edición para un elemento de inventario
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
    	Optional<InventoryItem> persona = inventoryitemrepository.findById(id); // Obtiene el elemento de inventario por su ID
    	model.addAttribute("persona", persona); // Agrega el elemento de inventario al modelo
    	return "formulario"; // Muestra el formulario de edición
    }
    
    // Elimina un elemento de inventario
    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id, Model model) {
    	service.delete(id); // Elimina el elemento de inventario por su ID
    	return "redirect:/dashboard"; // Redirige al tablero de instrumentos después de eliminar
    }
}


