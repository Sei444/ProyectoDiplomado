package com.proyecto.Modulo3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

public class UserRolDTO {

    private Integer id;


    private Boolean active;


    private LocalDateTime createdAt;


    private Integer userId;


    private Integer rolId;
    public UserRolDTO(){

    }
}
