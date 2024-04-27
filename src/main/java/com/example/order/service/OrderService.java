package com.example.order.service;

import com.example.order.dto.OrderDTO;
import com.example.order.entity.Order;
import com.example.order.repo.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class OrderService implements CommandLineRunner {

    private final ModelMapper mapper;
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) {
        createOrders();
    }

    public List<OrderDTO> getAllOrders(){
        return orderRepository.findAll()
                .stream()
                .map(order -> mapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByUserId(Long id){
        return orderRepository.findAllByUserId(id)
                .stream()
                .map(order -> mapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id){
        Order order = orderRepository.findById(id).get();
        return mapper.map(order, OrderDTO.class);
    }


    private void createOrders(){
        orderRepository.saveAll(List.of(
                new Order(null, 1L),
                new Order(null, 2L),
                new Order(null, 1L),
                new Order(null, 2L),
                new Order(null, 1L)
        ));
    }


}
