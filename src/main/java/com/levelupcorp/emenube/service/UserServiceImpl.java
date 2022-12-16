package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.User;
import com.levelupcorp.emenube.domain.request.UserRequest;
import com.levelupcorp.emenube.repository.UserRepository;
import com.levelupcorp.emenube.util.mapper.GenericMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private GenericMapper genericMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, GenericMapper genericMapper){
        this.userRepository = userRepository;
        this.genericMapper = genericMapper;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).map(order -> order).orElse(null);
    }

    public User createUser(UserRequest userRequest) {
        User newUser = new User();
        BeanUtils.copyProperties(userRequest, newUser);
        User savedUser = userRepository.save(newUser);
        return savedUser;
    }

    public User updateUser(UserRequest userRequest, Long userId) {
        User currentUser = findById(userId);

        if(currentUser == null){
            return null;
        }
        try {
            genericMapper.<UserRequest, User>copyProperties(userRequest, currentUser);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        User savedUser = userRepository.save(currentUser);
        return savedUser;
    }

    public Boolean deleteUser(Long userId) {
        try{
            userRepository.deleteById(userId);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
