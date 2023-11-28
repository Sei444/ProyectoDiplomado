package com.proyecto.Modulo3.repositories;

import com.proyecto.Modulo3.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolRepository extends JpaRepository<UserRol, Integer> {
}