package com.deniscury.park_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deniscury.park_api.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
