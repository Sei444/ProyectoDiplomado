package com.proyecto.Modulo3.web.rest.controller;


import com.proyecto.Modulo3.dto.UserDTO;
import com.proyecto.Modulo3.dto.UserRolDTO;
import com.proyecto.Modulo3.services.UserRolServices;
import com.proyecto.Modulo3.services.UserServices;
import com.proyecto.Modulo3.services.mappers.UserRolMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/userRol")
public class UserRolController {

    private final UserRolServices userRolServices;

    public UserRolController(UserRolServices userRolServices) {
        this.userRolServices = userRolServices;
    }

    @GetMapping
    public ResponseEntity<List<UserRolDTO>> listUserRol() {
        return ResponseEntity.ok().body(userRolServices.listUserRol());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRolDTO> getUserRolById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(userRolServices.getUserRolById(id).orElseThrow(() -> new IllegalArgumentException("Resource not found exception for the id: " + id)));
    }

    @PostMapping
    public ResponseEntity<UserRolDTO> create(@RequestBody final UserRolDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new UserRol cannot already have an id.");
        }

        UserRolDTO userRolDB = userRolServices.save(dto);

        return ResponseEntity.created(new URI("/v1/userRol/" + userRolDB.getId())).body(userRolDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRolDTO> editUserRol(@RequestBody final UserRolDTO dto,
                                            @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid user id, null value");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }

        return ResponseEntity
                .ok()
                .body(this.userRolServices.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> logicalDelete(@PathVariable final Integer id) {
        userRolServices.deleteUserRol(id);
        return ResponseEntity.ok().build();
    }


}
