package br.brazona.bzn_exemplo_services_profiles.infra.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Entity
@Table(name = "profiles")
@Component
public class ProfilesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
}
