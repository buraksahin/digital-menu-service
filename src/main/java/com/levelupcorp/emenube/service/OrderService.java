package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.Order;
import com.levelupcorp.emenube.domain.request.OrderRequest;
import com.levelupcorp.emenube.domain.request.OrdersRequest;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order getById(Long id);
    List<Order> getByTableId(Long tableId);
    List<Order> getByRestaurantId(Long restaurantId);
    List<Order> getByTableIdAndRestaurantId(Long tableId, Long restaurantId);
    List<Order> getByTableIdAndCustomerNameAndRestaurantId(Long tableId, String customerName, Long restaurantId);
    List<Order> getByTableIdAndCustomerName(Long tableId, String customerName);
    Order createOrder(OrderRequest orderRequest);
    List<Order> createOrders(OrdersRequest ordersRequest);
    Boolean deleteOrder(Long orderId);
}
