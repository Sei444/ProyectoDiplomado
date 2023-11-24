package com.proyecto.Modulo3.services.mappers;

import com.proyecto.Modulo3.dto.RolDTO;
import com.proyecto.Modulo3.dto.UserRolDTO;
import com.proyecto.Modulo3.entities.Rol;
import com.proyecto.Modulo3.entities.UserRol;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements CustomMapper <RolDTO, Rol> {

    @Override
    public UserRolDTO toDto(UserRol entity) {
        return null;
    }

    @Override
    public UserRol toEntity(UserRolDTO userRolDTO) {
        return null;
    }

    @Override
    public RolDTO toDto(Rol rol) {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setName(rol.getName());
        rolDTO.setId(rol.getId());
        return rolDTO;
    }

    @Override
    public Rol toEntity(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setName(rolDTO.getName());
        return rol;
    }
}