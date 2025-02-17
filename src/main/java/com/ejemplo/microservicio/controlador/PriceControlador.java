package com.ejemplo.microservicio.controlador;

import com.ejemplo.microservicio.modelo.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filter")
public class PriceControlador {

    @GetMapping("/price/{initial_range}/{final_range}")
    public ResponseEntity<List<Product>> filterByPrice(@PathVariable("initial_range") double initialRange,
                                                       @PathVariable("final_range") double finalRange) throws IOException {
        // Cargar datos desde el archivo JSON
        ClassPathResource resource = new ClassPathResource("products.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = mapper.readValue(resource.getInputStream(), new TypeReference<List<Product>>() {});

        // Filtrar productos por rango de precios
        List<Product> filteredProducts = products.stream()
                .filter(product -> {
                    double price = Double.parseDouble(product.getPrice());
                    return price >= initialRange && price <= finalRange;
                })
                .collect(Collectors.toList());

        if (filteredProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
        }
    }
}