package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.Order;
import com.levelupcorp.emenube.domain.entity.Table;
import com.levelupcorp.emenube.domain.request.OrderRequest;
import com.levelupcorp.emenube.domain.request.OrdersRequest;
import com.levelupcorp.emenube.repository.OrderRepository;
import com.levelupcorp.emenube.repository.TableRepository;
import com.levelupcorp.emenube.util.constant.ServiceConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private TableRepository tableRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, TableRepository tableRepository) {
        this.orderRepository = orderRepository;
        this.tableRepository = tableRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Long id) {
        return orderRepository.findById(id).map(order -> order).orElse(null);
    }

    public List<Order> getByTableId(Long tableId) {
        return orderRepository.findByTableId(tableId);
    }

    public List<Order> getByRestaurantId(Long restaurantId) {
        return orderRepository.findByRestaurantId(restaurantId);
    }

    public List<Order> getByTableIdAndRestaurantId(Long tableId, Long restaurantId) {
        return orderRepository.findByTableIdAndRestaurantId(tableId, restaurantId);
    }

    public List<Order> getByTableIdAndCustomerNameAndRestaurantId(Long tableId, String customerName, Long restaurantId) {
        return orderRepository.findByTableIdAndCustomerNameAndRestaurantId(tableId, customerName, restaurantId);
    }

    public List<Order> getByTableIdAndCustomerName(Long tableId, String customerName) {
        return orderRepository.findByTableIdAndCustomerName(tableId, customerName);
    }

    public Order createOrder(OrderRequest orderRequest) {
        Order newOrder = new Order();
        BeanUtils.copyProperties(orderRequest, newOrder);
        Table table = tableRepository.findByIdAndRestaurantIdAndSessionCode(newOrder.getTableId(), newOrder.getTableId(), orderRequest.getSessionCode()).map(a->a).orElse(null);
        if(table != null && table.getSessionCode().compareTo(orderRequest.getSessionCode()) == 0 && table.getTableStatus() == ServiceConstant.OPEN){
            Order savedOrder = orderRepository.save(newOrder);
            return savedOrder;
        }
        return null;
    }

    public List<Order> createOrders(OrdersRequest ordersRequest) {
        List<Order> listOfOrder = new ArrayList<Order>();
        listOfOrder = ordersRequest.getOrdersRequestList().stream().map(r->createOrder(r)).collect(Collectors.toList());
        return listOfOrder;
    }

    public Boolean deleteOrder(Long orderId) {
        try {
            orderRepository.deleteById(orderId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
