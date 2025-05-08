package br.brazona.bzn_exemplo_services_users.infra.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
    /**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
    private Long id;
	
    @Column(unique = true)
    private String email;
    
    public UserEntity() {
	}
    
    public UserEntity(Long id, String email) {
		this.id = id;
		this.email = email;
	}

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
