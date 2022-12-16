package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.Restaurant;
import com.levelupcorp.emenube.domain.request.RestaurantRequest;
import com.levelupcorp.emenube.repository.RestaurantRepository;
import com.levelupcorp.emenube.util.mapper.GenericMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepository restaurantRepository;
    private GenericMapper genericMapper;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, GenericMapper genericMapper){
        this.restaurantRepository = restaurantRepository;
        this.genericMapper = genericMapper;
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant getById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).map(a -> a).orElse(null);
    }

    public Restaurant createRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant newRestaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantRequest, newRestaurant);
        Restaurant savedRestaurant = restaurantRepository.save(newRestaurant);
        return savedRestaurant;
    }

    public Restaurant updateRestaurant(RestaurantRequest restaurantRequest, Long restaurantId){
        Restaurant currentRestaurant = getById(restaurantId);

        if(currentRestaurant == null){
            return null;
        }
        try {
            genericMapper.<RestaurantRequest, Restaurant>copyProperties(restaurantRequest, currentRestaurant);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Restaurant updatedRestaurant = restaurantRepository.save(currentRestaurant);
        return updatedRestaurant;
    }

    public Boolean deleteRestaurant(Long restaurantId) {
        try{
            restaurantRepository.deleteById(restaurantId);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
