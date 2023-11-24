package com.proyecto.Modulo3.web.rest.controller;


import com.proyecto.Modulo3.dto.UserDTO;
import com.proyecto.Modulo3.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok().body(userServices.listUsers());
    }

    @GetMapping(path = "/getUser/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long userId) {
        return ResponseEntity.ok().body(userServices.getUser(userId));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) throws URISyntaxException {
        if (user.getId() == null) {
            throw new IllegalArgumentException(
                    "A user  is been created with this userId, please review the  request body");
        }
        System.out.println(user);
        return ResponseEntity.ok().body(userServices.createUser(user));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long userId,@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok().body(userServices.updateUser(userId, user));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable("id") Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userServices.deleteUser(userId));
    }


}
