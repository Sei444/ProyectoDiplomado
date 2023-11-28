package com.proyecto.Modulo3.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter @Setter
@ToString
public class UserDTO {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createAt;
    private UserDetailDTO userDetailDTO;
    private List<RolDTO> roles;


    public UserDTO() {

    }
}
