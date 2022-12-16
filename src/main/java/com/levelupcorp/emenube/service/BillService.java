package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.vo.BillVO;

public interface BillService {
    BillVO getTotalBillByRestaurantId(Long restaurantId);
    BillVO getTotalBillByRestaurantIdAndTableId(Long restaurantId, Long tableId);

}
