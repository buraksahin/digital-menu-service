package com.levelupcorp.emenube.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableRequest implements Serializable {
    private String name;
    @JsonProperty("restaurant_id")
    private Long restaurantId;
    @JsonProperty("table_code")
    private String tableCode;
    @JsonProperty("table_status")
    private String tableStatus;
}
