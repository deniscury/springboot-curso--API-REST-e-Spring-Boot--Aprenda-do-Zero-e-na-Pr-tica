package com.deniscury.park_api.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deniscury.park_api.entity.User;
import com.deniscury.park_api.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User newUser = userService.save(user);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }  

    @GetMapping()
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getAll();

        return ResponseEntity.ok(users);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        User user = userService.getById(id);

        return ResponseEntity.ok(user);
    } 

    @PatchMapping("/{id}")
    public ResponseEntity<User> updatePassword(@PathVariable Long id, @RequestBody User user){
        User modifiedUser = userService.updatePassword(id, user.getPassword());

        return ResponseEntity.ok(modifiedUser);
    } 
}
