package com.example.order.service;

import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderItemDTO;
import com.example.order.entity.Order;
import com.example.order.entity.OrderItem;
import com.example.order.repo.OrderItemRepository;
import com.example.order.repo.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class OrderService {

    private final ModelMapper mapper;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> mapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrdersByUserId(Long id) {
        return orderRepository.findAllByUserId(id)
                .stream()
                .map(order -> mapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id).get();
        return mapper.map(order, OrderDTO.class);
    }

    public List<OrderItemDTO> getOrderItemsById(Long orderId){
        return orderItemRepository.findAllByOrderId(orderId)
                .stream()
                .map(orderItem -> mapper.map(orderItem, OrderItemDTO.class))
                .collect(Collectors.toList());
    }


}
