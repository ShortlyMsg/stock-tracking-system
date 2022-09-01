package com.trackingsys.stocktrackingsystem.controller;

import com.trackingsys.stocktrackingsystem.dto.ProductDto;
import com.trackingsys.stocktrackingsystem.dto.UserDto;
import com.trackingsys.stocktrackingsystem.entity.Product;
import com.trackingsys.stocktrackingsystem.entity.User;
import com.trackingsys.stocktrackingsystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") String userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") String userId){
        userService.deleteUserById(userId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(@RequestBody User user,
                                                        @PathVariable("id") String userId){
        return ResponseEntity.ok(userService.updateUserById(user, userId));
    }
}
