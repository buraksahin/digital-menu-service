package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.vo.BillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService{
    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public BillServiceImpl(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public BillVO getTotalBillByRestaurantId(Long restaurantId) {
        return null;
    }

    @Override
    public BillVO getTotalBillByRestaurantIdAndTableId(Long restaurantId, Long tableId) {
        return null;
    }
}
