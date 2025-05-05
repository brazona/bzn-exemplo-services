package br.brazona.bzn_exemplo_services_roles.domain.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "roles")
public class RolesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;

}
