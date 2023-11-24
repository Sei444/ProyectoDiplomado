package com.proyecto.Modulo3.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_rol")
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "active")
    private Boolean active;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime create_at;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(foreignKey =  @ForeignKey( name = "user_id"), nullable = true)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "rol_id"), nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Rol rol;

    public UserRol(Long id, Boolean active, LocalDateTime create_at, User userId, Rol rolId) {
        this.id = id;
        this.active = active;
        this.create_at = create_at;
        this.user = userId;
        this.rol = rolId;
    }

    public UserRol() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {

        this.create_at = create_at;
    }

    public Long getUser() {
        return user.getId();
    }


    public Long getRol() {

        return rol.getId();
    }

    public void setRol(Long rol) {
    }

    public void setUser(Long userId) {
    }
}
