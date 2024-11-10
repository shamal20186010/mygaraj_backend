package org.mygaraj.controller;

import lombok.RequiredArgsConstructor;
import org.mygaraj.dto.Order;
import org.mygaraj.entity.OrderEntity;
import org.mygaraj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
    @Autowired
    final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderEntity orderEntity) {
        Order savedOrder = orderService.saveOrder(orderEntity);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("/get-all-orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
