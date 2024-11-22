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
import com.deniscury.park_api.web.dto.UserCreateDTO;
import com.deniscury.park_api.web.dto.UserPasswordDTO;
import com.deniscury.park_api.web.dto.UserResponseDTO;
import com.deniscury.park_api.web.dto.mapper.UserMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserCreateDTO createDTO){
        User newUser = userService.save(UserMapper.toUser(createDTO));
        
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDTO(newUser));
    }  

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> getAll(){
        List<User> users = userService.getAll();

        return ResponseEntity.ok(UserMapper.toList(users));
    } 

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id){
        User user = userService.getById(id);

        return ResponseEntity.ok(UserMapper.toDTO(user));
    } 

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UserPasswordDTO userPasswordDTO){
        userService.updatePassword(id, userPasswordDTO.getCurrentPassword(), userPasswordDTO.getNewPassword(), userPasswordDTO.getConfirmPassword());

        return ResponseEntity.noContent().build();
    } 
}
