package com.proyecto.Modulo3.services;

import com.proyecto.Modulo3.dto.UserRolDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface UserRolServices {
    List<UserRolDTO> listUserRol();
    Optional<UserRolDTO> getUserRolById(Integer id);


    UserRolDTO save(UserRolDTO dto);
    void deleteUserRol(Integer id);
}
