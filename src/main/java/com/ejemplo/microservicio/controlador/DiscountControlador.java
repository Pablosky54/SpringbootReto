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
public class DiscountControlador {

    @GetMapping("/discount/{discount_percentage}")
    public ResponseEntity<List<Product>> filterByDiscount(@PathVariable("discount_percentage") Integer discountPercentage) throws IOException {
        // Cargar datos desde el archivo JSON
        ClassPathResource resource = new ClassPathResource("products.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = mapper.readValue(resource.getInputStream(), new TypeReference<List<Product>>() {});

        // Filtrar productos por porcentaje de descuento
        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getDiscount_percentage() > discountPercentage)
                .collect(Collectors.toList());

        if (filteredProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
        }
    }
}