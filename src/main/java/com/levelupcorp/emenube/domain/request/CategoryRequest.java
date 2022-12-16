package com.levelupcorp.emenube.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest implements Serializable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("restaurant_id")
    private Long restaurantId;
    @JsonProperty("list_order")
    private Integer listOrder;
}
