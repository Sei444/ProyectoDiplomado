package com.proyecto.Modulo3.services;

import com.proyecto.Modulo3.dto.UserDetailDTO;

import java.util.List;

public interface UserDetailServices {

    List<UserDetailDTO> listUserDetails();

    UserDetailDTO getUserDetail(Integer id);

    UserDetailDTO createUserDetail(UserDetailDTO userDetail);

    UserDetailDTO updateUserDetail(Integer id, UserDetailDTO userDetail);

    Integer deleteUserDetail(Integer id);
}
