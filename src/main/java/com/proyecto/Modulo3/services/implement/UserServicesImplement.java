package com.proyecto.Modulo3.services.implement;

import com.proyecto.Modulo3.dto.UserDTO;
import com.proyecto.Modulo3.entities.User;
import com.proyecto.Modulo3.repositories.UserRepository;
import com.proyecto.Modulo3.services.UserServices;
import com.proyecto.Modulo3.services.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<UserDTO> listUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(Long id) {
        List<User> listUser = userRepository.findAll();
        User res = new User();
        for (User aux : listUser) {
            if (aux.getId() == id) {
                res=aux;
                break;
            }
        }
        return this.userMapper.toDto(res);
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        return this.userMapper.toDto(
                userRepository.save(this.userMapper.toEntity(user)));
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO user) {
        User userRes = userRepository.getReferenceById(id);
        userRes.setUserName(user.getUsername());
        userRes.setPassword(user.getPassword());
        userRes.setId(user.getId());
        userRes.setCreateAt(user.getCreateAt());
        userRes.setEmail(user.getEmail());
        userRepository.save(userRes);
        return this.userMapper.toDto(userRes);
    }

    @Override
    public Long deleteUser(Long id) {
        userRepository.deleteById(Long.valueOf(id));
        return id;
    }
}
