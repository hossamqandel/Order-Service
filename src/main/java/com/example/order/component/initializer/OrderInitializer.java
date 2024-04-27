package com.example.order.component.initializer;

import com.example.order.entity.Order;
import com.example.order.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrderInitializer implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    private void createOrders() {
        orderRepository.saveAll(List.of(
                new Order(1L, 1L),
                new Order(2L, 2L),
                new Order(3L, 1L),
                new Order(4L, 2L),
                new Order(5L, 1L)
        ));
    }

    @Override
    public void run(String... args) {
        createOrders();
        System.out.println("Orders Saved Into DataBase");
    }
}
