package br.brazona.bzn_exemplo_services_users.domain.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Component
public class UsersEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
