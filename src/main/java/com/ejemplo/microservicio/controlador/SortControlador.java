package com.ejemplo.microservicio.controlador;

import com.ejemplo.microservicio.modelo.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sort")
public class SortControlador {

    @GetMapping("/price")
    public ResponseEntity<List<String>> sortByPrice() throws IOException {
        // Cargar datos desde el archivo JSON
        ClassPathResource resource = new ClassPathResource("products.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = mapper.readValue(resource.getInputStream(), new TypeReference<List<Product>>() {});

        // Ordenar productos por precio en orden ascendente y obtener solo los nombres de los productos
        List<String> sortedProductNames = products.stream()
                .sorted((p1, p2) -> Double.compare(Double.parseDouble(p1.getPrice()), Double.parseDouble(p2.getPrice())))
                .map(Product::getName)
                .collect(Collectors.toList());

        return new ResponseEntity<>(sortedProductNames, HttpStatus.OK);
    }
}