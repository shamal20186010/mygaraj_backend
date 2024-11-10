package org.mygaraj.service;

import org.mygaraj.dto.Order;
import org.mygaraj.entity.OrderEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {
    Order saveOrder(OrderEntity orderEntity);
    List<Order> getAllOrders();
}
