package com.proyecto.Modulo3.services;

import com.proyecto.Modulo3.dto.RolDTO;

import java.util.List;


public interface RolServices {
    List<RolDTO> listRol();

    RolDTO getRol(Long id);

    RolDTO createRol(RolDTO rol);

    Long deleteRol(Long id);
    RolDTO updateRol(Long id, RolDTO rol);

}
