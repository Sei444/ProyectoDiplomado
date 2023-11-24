package com.proyecto.Modulo3.services;

import com.proyecto.Modulo3.dto.UserRolDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserRolServices {
    List<UserRolDTO> listUserRol();
    UserRolDTO getUserRol(Long id);
    UserRolDTO createUserRol(UserRolDTO userRol);
    UserRolDTO updateUserRol(Long id, UserRolDTO userRol);
    Long deleteUserRol(Long id);
    boolean setActive(Long id);
}
