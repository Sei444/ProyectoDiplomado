package com.proyecto.Modulo3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @jakarta.persistence.Id
    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "username")
    private String userName;

    @Getter @Setter
    @Column(name = "password")
    private String password;

    @Getter @Setter
    @Column(name = "email")
    private String email;

    @Getter @Setter
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createAt;



    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
