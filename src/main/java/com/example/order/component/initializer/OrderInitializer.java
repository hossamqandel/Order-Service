package com.example.order.component.initializer;

import com.example.order.entity.Order;
import com.example.order.entity.OrderItem;
import com.example.order.repo.OrderItemRepository;
import com.example.order.repo.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class OrderInitializer implements CommandLineRunner {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) {
        createOrders();
        createOrderItems();
    }

    private void createOrders(){
        orderRepository.saveAll(List.of(
                new Order(1L, 2L, 3L, null),
                new Order(2L, 1L, 2L, null),
                new Order(3L, 2L, 1L, null)
        ));
    }

    private void createOrderItems() {
        orderItemRepository.saveAll(List.of(
                new OrderItem(1L, 1L, 1L, 3, null),
                new OrderItem(2L, 1L, 1L, 2, null),
                new OrderItem(3L, 2L, 2L, 5, null)
        ));
    }


}
