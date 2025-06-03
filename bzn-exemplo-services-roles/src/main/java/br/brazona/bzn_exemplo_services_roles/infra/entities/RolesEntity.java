package br.brazona.bzn_exemplo_services_roles.infra.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "roles")
@Component
public class RolesEntity implements Serializable {
	
    @Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String name;

    public RolesEntity() {
    }

    public RolesEntity(String name) {
        this.name = name;
    }
    
    public RolesEntity(Long id, String name) {
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
