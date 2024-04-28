package com.example.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private Long userId;
    private Integer statusId;
    private Set<OrderItemDTO> orderItems;

}
