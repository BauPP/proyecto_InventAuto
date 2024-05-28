package com.tienda.inventorymanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indica que esta clase es una configuración de Spring
@EnableWebSecurity // Habilita la seguridad web en la aplicación
public class SecurityConfig {
    
    // Configuración del codificador de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Utiliza BCryptPasswordEncoder como codificador de contraseñas
    }

    // Configuración de la cadena de filtros de seguridad para la API
    @Bean
    SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults()) // Configura CORS con las opciones predeterminadas
            .csrf(AbstractHttpConfigurer::disable) // Deshabilita CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/**") // Autoriza todas las solicitudes
                .permitAll()); // Permite a todos acceder a todas las solicitudes
        return http.build(); // Construye la cadena de filtros de seguridad y la devuelve
    }
}
