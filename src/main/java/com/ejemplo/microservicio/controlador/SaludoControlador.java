package com.ejemplo.microservicio.controlador;

import com.ejemplo.microservicio.modelo.Saludo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class SaludoControlador {

    @GetMapping
    public Saludo obtenerSaludo() {
        return new Saludo("¡Hola, mundo!");
    }

}