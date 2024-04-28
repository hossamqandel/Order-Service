package com.example.order.component.initializer;

import com.example.order.entity.Product;
import com.example.order.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        productRepository.saveAll(createProducts());
    }

    private List<Product> createProducts(){
        var data = new Product(1L, "Playstation 4", 20.0);
        var data2 = new Product(2L, "DVD", 6.5);
        var data3 = new Product(3L, "Laptop", 200.0);
        return List.of(data, data2, data3);
    }
}
