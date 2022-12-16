package com.levelupcorp.emenube.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersRequest implements Serializable {
    @JsonProperty("orders")
    private List<OrderRequest> ordersRequestList;
    private String sessionCode;
}
