package com.proyecto.Modulo3.services;

import com.proyecto.Modulo3.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserServices {

    List<UserDTO> listUsers();
    UserDTO getUser(Long id);
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(Long id, UserDTO user);
    Long deleteUser(Long id);
}
