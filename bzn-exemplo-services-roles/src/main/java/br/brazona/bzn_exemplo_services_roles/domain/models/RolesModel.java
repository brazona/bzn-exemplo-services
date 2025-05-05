package br.brazona.bzn_exemplo_services_roles.domain.models;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
public class RolesModel implements Serializable {

    private Long id;
    @Column(unique = true)
    private String name;

    public RolesModel() {
    }

    public RolesModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
