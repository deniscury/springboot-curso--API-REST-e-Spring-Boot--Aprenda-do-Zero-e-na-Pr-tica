package com.deniscury.park_api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deniscury.park_api.entity.User;
import com.deniscury.park_api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getById(Long id){
        return userRepository.findById(id).orElseThrow(
            () -> new RuntimeException("User not found!")
        );
    }

    @Transactional(readOnly = true)
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Transactional
    public User updatePassword(Long id, String password){
        User user = getById(id);

        user.setPassword(password);

        return user;
    }
}
