package com.proyecto.Modulo3.services;

import com.proyecto.Modulo3.dto.UserDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserDetailServices {

    List<UserDetailDTO> listUserDetails();

    UserDetailDTO getUserDetail(Long id);

    UserDetailDTO createUserDetail(UserDetailDTO userDetail);

    UserDetailDTO updateUserDetail(Long id, UserDetailDTO userDetail);

    Long deleteUserDetail(Long id);
}
