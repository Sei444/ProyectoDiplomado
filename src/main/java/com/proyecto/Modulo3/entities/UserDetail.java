package com.proyecto.Modulo3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_detail")
public class UserDetail {
    @Getter @Setter
    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter @Setter
    @Column(name = "age")
    private Integer age;

    @Getter @Setter
    @Column(name = "birth_day")
    private LocalDateTime birth_day;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "user_id"), nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;


    public UserDetail() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
