package com.ejemplo.microservicio.controlador;

import com.ejemplo.microservicio.modelo.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rating")
public class RatingControlador {

    @PostMapping("/compute")
    public List<Product> computeRatings() throws IOException {
        // Cargar datos desde el archivo JSON
        ClassPathResource resource = new ClassPathResource("products.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = mapper.readValue(resource.getInputStream(), new TypeReference<List<Product>>() {});

        // Calcular el promedio de las calificaciones para cada producto
        List<Product> computedRatings = products.stream()
                .map(product -> {
                    double averageRating = product.getAverageRating();
                    Product productWithRating = new Product();
                    productWithRating.setName(product.getName());
                    productWithRating.setPrice(product.getPrice());
                    productWithRating.setDiscount_percentage(product.getDiscount_percentage());
                    productWithRating.setImage(product.getImage());
                    productWithRating.setDetail(product.getDetail());
                    productWithRating.setRatings(product.getRatings());
                    return productWithRating;
                })
                .collect(Collectors.toList());

        return computedRatings;
    }
}