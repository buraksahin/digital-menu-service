package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.Restaurant;
import com.levelupcorp.emenube.domain.request.RestaurantRequest;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAll();
    Restaurant getById(Long restaurantId);
    Restaurant createRestaurant(RestaurantRequest restaurantRequest);
    Restaurant updateRestaurant(RestaurantRequest restaurantRequest, Long restaurantId);
    Boolean deleteRestaurant(Long restaurantId);
}
