package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.User;
import com.levelupcorp.emenube.domain.request.UserRequest;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long userId);
    User createUser(UserRequest userRequest);
    User updateUser(UserRequest userRequest, Long userId);
    Boolean deleteUser(Long userId);
}
