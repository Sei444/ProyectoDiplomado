package com.proyecto.Modulo3.web.rest.controller;

import com.proyecto.Modulo3.dto.RolDTO;
import com.proyecto.Modulo3.services.RolServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/roles")
public class RolController {


    private final RolServices rolServices;


    public RolController(RolServices rolServices) {
        this.rolServices = rolServices;
    }

    @GetMapping(path = "/getAllObjects")
    public ResponseEntity<List<RolDTO>> getAllRol() {
        return ResponseEntity.ok().body(rolServices.listRol());
    }

    @GetMapping(path = "/get/{id}")
    public RolDTO getRol(@PathVariable("id") Long rolId) {
        return rolServices.getRol(rolId);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<RolDTO> createRol(@Validated @RequestBody RolDTO rolDTO) throws URISyntaxException {

        return ResponseEntity.created(null).body(rolServices.createRol(rolDTO));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<RolDTO> updateRol(@PathVariable("id") Integer rolId, @RequestBody RolDTO rol) {

        return ResponseEntity.ok().body(rolServices.updateRol(rolId, rol));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Long> deleteRol(@PathVariable("id") Long rolId) {
        rolServices.deleteRol(rolId);
        return ResponseEntity.status(HttpStatus.OK).body(rolId);
    }
}