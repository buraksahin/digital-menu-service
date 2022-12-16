package com.levelupcorp.emenube.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest implements Serializable {
    @JsonProperty("table_id")
    private Long tableId;
    @JsonProperty("restaurant_id")
    private Long restaurantId;
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("customer_name")
    private String customerName;
    @JsonProperty("list_order")
    private Integer listOrder;
    @JsonProperty("session_id")
    private Long sessionId;
    @JsonProperty("sessionCode")
    private String sessionCode;
}
