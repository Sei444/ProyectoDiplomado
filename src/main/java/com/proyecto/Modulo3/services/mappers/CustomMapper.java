package com.proyecto.Modulo3.services.mappers;

import com.proyecto.Modulo3.dto.UserRolDTO;
import com.proyecto.Modulo3.entities.UserRol;

public interface CustomMapper<DTO, T> {
    UserRolDTO toDto(UserRol entity);

    UserRol toEntity(UserRolDTO userRolDTO);

    DTO toDto(T entity);

    T toEntity(DTO dto);

}
