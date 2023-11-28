package com.proyecto.Modulo3.services;

import com.proyecto.Modulo3.dto.RolDTO;

import java.util.List;


public interface RolServices {
    List<RolDTO> listRol();

    RolDTO getRol(Integer id);

    RolDTO createRol(RolDTO rol);

    Integer deleteRol(Integer id);
    RolDTO updateRol(Integer id, RolDTO rol);

}
