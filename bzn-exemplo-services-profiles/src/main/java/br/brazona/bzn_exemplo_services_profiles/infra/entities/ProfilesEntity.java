package br.brazona.bzn_exemplo_services_profiles.infra.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "profiles")
public class ProfilesEntity implements Serializable {
    /**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String name;
    
    private Long userId;
   
    private Long roleId;

	public ProfilesEntity() {
		super();
	}

	public ProfilesEntity(String name, Long userId, Long roleId) {
		super();
		this.name = name;
		this.userId = userId;
		this.roleId = roleId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
       
}
