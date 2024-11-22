package com.deniscury.park_api.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.deniscury.park_api.entity.User;
import com.deniscury.park_api.web.dto.UserCreateDTO;
import com.deniscury.park_api.web.dto.UserResponseDTO;

public class UserMapper {
    public static User toUser(UserCreateDTO createDTO){
        return new ModelMapper().map(createDTO, User.class);
    }

    public static UserResponseDTO toDTO(User user){
        String role = user.getRole().name().substring("ROLE_".length());

        PropertyMap<User, UserResponseDTO> properties = new PropertyMap<User,UserResponseDTO>() {
            @Override
            protected void configure(){
                map().setRole(role);
            }
        };

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(properties);

        return modelMapper.map(user, UserResponseDTO.class);
    }

    public static List<UserResponseDTO> toList(List<User> users){
        return users.stream().map(user -> toDTO(user)).collect(Collectors.toList());
    }
}
