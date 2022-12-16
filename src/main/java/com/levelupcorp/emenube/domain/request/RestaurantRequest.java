package com.levelupcorp.emenube.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequest implements Serializable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("table_limit")
    private Integer tableLimit;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("mail")
    private String mail;
}
