package com.proyecto.Modulo3.services.implement;

import com.proyecto.Modulo3.dto.RolDTO;
import com.proyecto.Modulo3.entities.Rol;
import com.proyecto.Modulo3.repositories.RolRepository;
import com.proyecto.Modulo3.services.RolServices;
import com.proyecto.Modulo3.services.mappers.RolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServicesImplement implements RolServices {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolServicesImplement(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public List<RolDTO> listRol() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public RolDTO getRol(Integer id) {
        List<Rol> listRol = rolRepository.findAll();
        Rol res = new Rol();
        for (Rol aux : listRol) {
            if (aux.getId() == id) {
                res=aux;
                break;
            }
        }
        return this.rolMapper.toDto(res);
    }

    @Override
    public RolDTO createRol(RolDTO rolDTO) {
        return this.rolMapper.toDto(rolRepository.save(this.rolMapper.toEntity(rolDTO)));
    }



    @Override
    public RolDTO updateRol(Integer id, RolDTO rol) {
        Rol rolRes = rolRepository.getReferenceById(id);
        rolRes.setId(rol.getId());
        rolRes.setName(rol.getName());
        rolRepository.save(rolRes);
        return this.rolMapper.toDto(rolRes);
    }

    @Override
    public Integer deleteRol(Integer id) {
        rolRepository.deleteById(id);
        return id;
    }
}