package org.mygaraj.service.impl;


import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.mygaraj.dto.Order;
import org.mygaraj.dto.Product;
import org.mygaraj.entity.OrderEntity;
import org.mygaraj.reporsitory.OrderRepository;
import org.mygaraj.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper mapper;

    @Override
    public Order saveOrder(OrderEntity orderEntity) {
        OrderEntity savedOrder = orderRepository.save(orderEntity);
        return mapper.map(savedOrder, Order.class); // Return saved order as DTO
    }

    @Override
    public List<Order> getAllOrders() {
        List<OrderEntity> orderEntities = (List<OrderEntity>) orderRepository.findAll();
        return orderEntities.stream()
                .map(order -> mapper.map(order, Order.class))
                .collect(Collectors.toList());
    }
}
