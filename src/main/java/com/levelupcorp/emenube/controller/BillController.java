package com.levelupcorp.emenube.controller;

import com.levelupcorp.emenube.domain.entity.Order;
import com.levelupcorp.emenube.domain.vo.BillVO;
import com.levelupcorp.emenube.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {
    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/get-by-restaurant-id/{restaurant-id}")
    public ResponseEntity<BillVO> getTotalBillByRestaurantId(@PathVariable("restaurant-id") Long restaurantId) {
        return ResponseEntity.ok(billService.getTotalBillByRestaurantId(restaurantId));
    }

    @GetMapping("/get-by-restaurant-id-and-table-id/{restaurant-id}/{table-id}")
    public ResponseEntity<BillVO> getTotalBillByRestaurantId(@PathVariable("restaurant-id") Long restaurantId, @PathVariable("table-id") Long tableId) {
        return ResponseEntity.ok(billService.getTotalBillByRestaurantIdAndTableId(restaurantId, tableId));
    }

}
