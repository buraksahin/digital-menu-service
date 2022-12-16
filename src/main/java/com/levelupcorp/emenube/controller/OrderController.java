package com.levelupcorp.emenube.controller;

import com.levelupcorp.emenube.domain.entity.Order;
import com.levelupcorp.emenube.domain.request.OrderRequest;
import com.levelupcorp.emenube.domain.request.OrdersRequest;
import com.levelupcorp.emenube.service.OrderService;
import com.levelupcorp.emenube.util.annotation.CustomerNameValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/get-by-order-id/{order-id}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable("order-id") Long orderId) {
        return ResponseEntity.ok(orderService.getById(orderId));
    }

    @GetMapping("/get-by-table-id/{table-id}")
    public ResponseEntity<List<Order>> getOrdersByTableId(@PathVariable("table-id") Long tableId) {
        return ResponseEntity.ok(orderService.getByTableId(tableId));
    }

    @GetMapping("/get-by-restaurant-id/{restaurant-id}")
    public ResponseEntity<List<Order>> getOrdersByResturantId(@PathVariable("restaurant-id") Long restaurantId) {
        return ResponseEntity.ok(orderService.getByRestaurantId(restaurantId));
    }

    @GetMapping("/get-by-table-id-and-customer-name/{table-id}/{customer-name}")
    public ResponseEntity<List<Order>> getOrdersByTableIdAndCustomerName(@PathVariable("table-id") Long tableId,@CustomerNameValidation @PathVariable("customer-name") String customerName) {
        return ResponseEntity.ok(orderService.getByTableIdAndCustomerName(tableId, customerName));
    }

    @GetMapping("/get-by-table-id-and-customer-name-and-restaurant-id/{table-id}/{customer-name}/{restaurant-id}")
    public ResponseEntity<List<Order>> getByTableIdAndCustomerNameAndRestaurantId(@PathVariable("table-id") Long tableId,@PathVariable("customer-name") String customerName, @PathVariable("restaurant-id") Long restaurantId) {
        return ResponseEntity.ok(orderService.getByTableIdAndCustomerNameAndRestaurantId(tableId,customerName, restaurantId));
    }

    @GetMapping("/get-by-table-id-and-restaurant-id/{table-id}/{restaurant-id}")
    public ResponseEntity<List<Order>> getOrdersByTableId(@PathVariable("table-id") Long tableId, @PathVariable("restaurant-id") Long restaurantId) {
        return ResponseEntity.ok(orderService.getByTableIdAndRestaurantId(tableId, restaurantId));
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody @Valid OrderRequest orderRequest) {
        Order createdOrder = orderService.createOrder(orderRequest);
        return ResponseEntity.ok(createdOrder);
    }

    @PostMapping("/create-orders")
    public ResponseEntity<List<Order>> createOrder(@RequestBody @Valid OrdersRequest ordersRequest) {
        List<Order> createdOrders = orderService.createOrders(ordersRequest);
        return ResponseEntity.ok(createdOrders);
    }

    @DeleteMapping("/delete/{order-id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable("order-id") @Valid Long orderId) {
        return ResponseEntity.ok(orderService.deleteOrder(orderId));
    }
}
