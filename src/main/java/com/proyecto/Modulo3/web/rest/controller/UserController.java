package com.proyecto.Modulo3.web.rest.controller;


import java.net.URI;
import java.util.Objects;
import java.util.Optional;
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

    private final UserServices userService;

    public UserController(UserServices userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsers() {
        return ResponseEntity.ok().body(userService.listUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("Resource not found exception for the id: " + id)));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody final UserDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new student cannot already have an id.");
        }

        UserDTO userDB = userService.save(dto);

        return ResponseEntity.created(new URI("/v1/users/" + userDB.getId())).body(userDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> editUser(@RequestBody final UserDTO dto,
                                                  @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid user id, null value");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }

        return ResponseEntity
                .ok()
                .body(this.userService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> logicalDelete(@PathVariable final Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}
