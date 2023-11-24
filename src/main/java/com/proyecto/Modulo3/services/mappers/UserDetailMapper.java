package com.proyecto.Modulo3.services.mappers;

import com.proyecto.Modulo3.dto.UserDetailDTO;
import com.proyecto.Modulo3.dto.UserRolDTO;
import com.proyecto.Modulo3.entities.UserDetail;
import com.proyecto.Modulo3.entities.UserRol;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper implements CustomMapper<UserDetailDTO, UserDetail> {
    @Override
    public UserRolDTO toDto(UserRol entity) {
        return null;
    }

    @Override
    public UserRol toEntity(UserRolDTO userRolDTO) {
        return null;
    }

    @Override
    public UserDetailDTO toDto(UserDetail userDetail) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setId(userDetail.getId());
        userDetailDTO.setUser(userDetail.getUser());
        userDetailDTO.setAge(userDetail.getAge());
        userDetailDTO.setFirstName(userDetail.getFirstName());
        userDetailDTO.setLastName(userDetail.getLastName());

        return userDetailDTO;
    }

    @Override
    public UserDetail toEntity(UserDetailDTO userDetailDTO) {
        UserDetail userDetail = new UserDetail();
        userDetail.setId(userDetailDTO.getId());
        userDetail.setFirstName(userDetailDTO.getFirstName());
        userDetail.setLastName(userDetailDTO.getLastName());
        userDetail.setAge(userDetailDTO.getAge());
        userDetail.setUser(userDetailDTO.getUser());
        return userDetail;
    }
}