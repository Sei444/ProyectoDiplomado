package com.proyecto.Modulo3.services.implement;


import com.proyecto.Modulo3.dto.UserRolDTO;
import com.proyecto.Modulo3.entities.UserRol;
import com.proyecto.Modulo3.repositories.UserRolRepository;
import com.proyecto.Modulo3.services.UserRolServices;
import com.proyecto.Modulo3.services.mappers.UserRolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRolServicesImplement implements UserRolServices {

    private final UserRolRepository userRolRepository;
    private final UserRolMapper userRolMapper;

    public UserRolServicesImplement(UserRolRepository userRolRepository, UserRolMapper userRolMapper) {
        this.userRolRepository = userRolRepository;
        this.userRolMapper = userRolMapper;
    }

    @Override
    public List<UserRolDTO> listUserRol() {
        return userRolRepository.findAll().stream()
                .map(userRolMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserRolDTO getUserRol(Long id) {
        List<UserRol> listUserRol = userRolRepository.findAll();
        UserRol res = new UserRol();
        for (UserRol aux : listUserRol) {
            if (aux.getId() == id) {
                res = aux;
                break;
            }
        }
        return this.userRolMapper.toDto(res);
    }

    @Override
    public UserRolDTO createUserRol(UserRolDTO userRol) {
        return this.userRolMapper.toDto(userRolRepository.save(this.userRolMapper.toEntity(userRol)));
    }

    @Override
    public UserRolDTO updateUserRol(Long id, UserRolDTO userRol) {
        UserRol userRolRes = userRolRepository.getReferenceById(id);
        userRolRes.setRol(userRol.getRolId());
        userRolRes.setUser(userRol.getUserId());
        userRolRes.setActive(userRol.getActive());
        userRolRepository.save(userRolRes);
        return this.userRolMapper.toDto(userRolRes);
    }

    @Override
    public Long deleteUserRol(Long id) {
        userRolRepository.deleteById(id);
        return id;
    }

    @Override
    public boolean setActive(Long id) {
        UserRol userRolRes = userRolRepository.getReferenceById(id);
        if (userRolRes.getActive()) {
            userRolRes.setActive(false);
        } else {
            userRolRes.setActive(true);
        }
        userRolRepository.save(userRolRes);
        return userRolRes.getActive();
    }
}
