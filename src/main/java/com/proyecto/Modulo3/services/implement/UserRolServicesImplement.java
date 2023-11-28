package com.proyecto.Modulo3.services.implement;


import com.proyecto.Modulo3.dto.UserRolDTO;
import com.proyecto.Modulo3.entities.UserRol;
import com.proyecto.Modulo3.repositories.UserRolRepository;
import com.proyecto.Modulo3.services.UserRolServices;
import com.proyecto.Modulo3.services.mappers.UserRolMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
    @Transactional(readOnly = true)
    public List<UserRolDTO> listUserRol() {
        return userRolRepository.findAll()
                .stream()
                .map(userRolMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserRolDTO save(UserRolDTO dto) {
        return this.userRolMapper
                .toDto(userRolRepository.save(this.userRolMapper.toEntity(dto)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserRolDTO> getUserRolById(Integer id) {
        return userRolRepository.findById(id).map(userRolMapper::toDto);
    }

    @Override
    public void deleteUserRol(Integer id) {
        UserRol userRol = userRolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with id: " + id + " is not existed."));
        userRolRepository.save(userRol);
    }
}
