package com.proyecto.Modulo3.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_rol", schema = "public")
public class UserRol {

    @Id
    @SequenceGenerator(name = "user_rol_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_rol_sequence")
    @Column(name = "id")
    private Integer id;


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

    public UserRol(Integer id, Boolean active, LocalDateTime create_at, User userId, Rol rolId) {
        this.id = id;
        this.active = active;
        this.create_at = create_at;
        this.user = userId;
        this.rol = rolId;
    }

    public UserRol() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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


    public void setUser(Integer userId) {
    }

    public void setRol(Integer rolId) {
    }
}
