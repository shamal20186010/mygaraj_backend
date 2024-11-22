package org.mygaraj.service;

import org.mygaraj.dto.Order;
import org.mygaraj.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    Order saveOrder(OrderEntity orderEntity);
    List<Order> getAllOrders();
}
