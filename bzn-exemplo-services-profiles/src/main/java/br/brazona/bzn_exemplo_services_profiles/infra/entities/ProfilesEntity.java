package br.brazona.bzn_exemplo_services_profiles.infra.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Entity
@Table(name = "profiles")
@Component
public class ProfilesEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(unique = true)
    @NotBlank
    private String name;
    
    @NotBlank
    @Column(name = "user_id", nullable = true, length = 12)
    private Long userId;
   
    @NotBlank
    @Column(name = "role_id", nullable = true, length = 12)
    private Long roleId;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
    
    
    
    
}
