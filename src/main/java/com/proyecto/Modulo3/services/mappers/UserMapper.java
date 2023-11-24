package com.proyecto.Modulo3.services.mappers;

import com.proyecto.Modulo3.dto.UserDTO;
import com.proyecto.Modulo3.dto.UserRolDTO;
import com.proyecto.Modulo3.entities.User;
import com.proyecto.Modulo3.entities.UserRol;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements CustomMapper<UserDTO, User> {

    @Override
    public UserRolDTO toDto(UserRol entity) {
        return null;
    }

    @Override
    public UserRol toEntity(UserRolDTO userRolDTO) {
        return null;
    }

    @Override
    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(userDTO.getUsername());
        userDTO.setEmail(userDTO.getEmail());
        userDTO.setPassword(userDTO.getPassword());
        userDTO.setCreateAt(userDTO.getCreateAt());
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreateAt(userDTO.getCreateAt());
        return user;
    }
}
