package com.proyecto.Modulo3.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private LocalDateTime createAt;

    @Getter
    @Setter
    private UserDetailDTO userDetailDTO;

    @Getter
    @Setter
    private List<RolDTO> roles;
}
