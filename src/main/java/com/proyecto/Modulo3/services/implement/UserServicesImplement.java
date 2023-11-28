package com.proyecto.Modulo3.services.implement;

import com.proyecto.Modulo3.dto.UserDTO;
import com.proyecto.Modulo3.entities.User;
import com.proyecto.Modulo3.repositories.UserRepository;
import com.proyecto.Modulo3.services.UserServices;
import com.proyecto.Modulo3.services.mappers.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServicesImplement implements UserServices {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServicesImplement(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserDTO dto) {
        return this.userMapper
                .toDto(userRepository.save(this.userMapper.toEntity(dto)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> getUserById(Integer id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with id: " + id + " is not existed."));
        userRepository.save(user);
    }
}
