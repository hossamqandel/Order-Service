package com.example.order.service;

import com.example.order.dto.ProductDTO;
import com.example.order.entity.Product;
import com.example.order.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ModelMapper mapper;
    private final ProductRepository productRepository;


    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> mapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }
}
