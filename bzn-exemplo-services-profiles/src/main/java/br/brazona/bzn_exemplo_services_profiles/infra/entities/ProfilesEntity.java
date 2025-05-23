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
    private Long id;
	
    private String name;
    
    private Integer userId;
   
    private Integer roleId;

	public ProfilesEntity() {
		super();
	}

	public ProfilesEntity(Long id, String name, Integer userId, Integer roleId) {
		super();
		this.id = id;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
       
}
