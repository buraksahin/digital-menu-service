package com.levelupcorp.emenube.controller;

import com.levelupcorp.emenube.domain.entity.User;
import com.levelupcorp.emenube.domain.request.UserRequest;
import com.levelupcorp.emenube.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/get-by-user-id/{user-id}")
    public ResponseEntity<User> getUserByUserId(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest userRequest) {
        User createdUser = userService.createUser(userRequest);
        return ResponseEntity.ok(createdUser);
    }

    @PatchMapping("/update/{user-id}")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest, @PathVariable("user-id") Long userId) {
        User updatedUser = userService.updateUser(userRequest, userId);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{user-id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("user-id") @Valid Long userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }
}
