package com.proyecto.Modulo3.web.rest.controller;


import com.proyecto.Modulo3.dto.UserRolDTO;
import com.proyecto.Modulo3.services.UserRolServices;
import com.proyecto.Modulo3.services.mappers.UserRolMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/userRol")
public class UserRolController {

    private final UserRolServices userRolServices;

    public UserRolController(UserRolServices userRolServices, UserRolMapper userRolMapper) {
        this.userRolServices = userRolServices;
    }

    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<UserRolDTO>> getAllUsersRol() {
        return ResponseEntity.ok().body(userRolServices.listUserRol());
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<UserRolDTO> getUserRol(@PathVariable("id") Long userRolId) {
        return ResponseEntity.ok().body(userRolServices.getUserRol(userRolId));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserRolDTO> createRolUser(@RequestBody UserRolDTO userRol) throws URISyntaxException {
        return ResponseEntity.created(null).body(userRolServices.createUserRol(userRol));
    }


    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UserRolDTO> updateUserRol(@PathVariable("id") Long userIdRol, @RequestBody UserRolDTO userRol) {
        return ResponseEntity.ok().body(userRolServices.updateUserRol(userIdRol, userRol));
    }

    @DeleteMapping(path = "/delete/{id}")
    public Long deleteUserRol(@PathVariable("id") Long userIdRol) {
        userRolServices.deleteUserRol(userIdRol);
        return userIdRol;
    }

    @PatchMapping(path = "/active/{id}")
    public boolean setActive(@PathVariable("id")Long userIdRol){
        return userRolServices.setActive(userIdRol);
    }


}
