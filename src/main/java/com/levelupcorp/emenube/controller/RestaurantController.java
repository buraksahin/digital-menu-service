package com.levelupcorp.emenube.controller;

import com.levelupcorp.emenube.domain.entity.Restaurant;
import com.levelupcorp.emenube.domain.request.RestaurantRequest;
import com.levelupcorp.emenube.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        return ResponseEntity.ok(restaurantService.getAll());
    }

    @GetMapping("/get-by-restaurant-id/{restaurant-id}")
    public ResponseEntity<Restaurant> getRestaurantByestaurantId(@PathVariable("restaurant-id") Long restaurantId) {
        return ResponseEntity.ok(restaurantService.getById(restaurantId));
    }

    @PostMapping("/create")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest) {
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurantRequest);
        return ResponseEntity.ok(createdRestaurant);
    }

    @PatchMapping("/update/{restaurant-id}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest, @PathVariable("restaurant-id") Long restaurantId) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurantRequest, restaurantId);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/delete/{restaurant-id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable("restaurant-id") @Valid Long restaurantId) {
        return ResponseEntity.ok(restaurantService.deleteRestaurant(restaurantId));
    }
}
