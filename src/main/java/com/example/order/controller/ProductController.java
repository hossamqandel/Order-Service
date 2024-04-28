package com.example.order.controller;

import com.example.order.dto.OrderDTO;
import com.example.order.dto.ProductDTO;
import com.example.order.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllOrders(){
        List<ProductDTO> products = productService.getAllProducts();
        if (products.isEmpty()) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
