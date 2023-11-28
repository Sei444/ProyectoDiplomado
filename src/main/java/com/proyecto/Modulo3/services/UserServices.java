package com.proyecto.Modulo3.services;

import com.proyecto.Modulo3.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface UserServices {

    List<UserDTO> listUsers();
    UserDTO save(UserDTO dto);
    Optional<UserDTO> getUserById(Integer id);
    void deleteUser(Integer id);
}
