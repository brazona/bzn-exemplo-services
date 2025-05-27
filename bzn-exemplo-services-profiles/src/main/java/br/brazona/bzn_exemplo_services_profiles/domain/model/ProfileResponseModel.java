package br.brazona.bzn_exemplo_services_profiles.domain.model;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**Classe modelo Perfil.
* @author Brazona Tech
* @version 1.0.0
* @since release 1.0.0
*/

@Component
@ApiModel(description = "Modelo objeto Perfil")
public class ProfileResponseModel {
	
  @ApiModelProperty(
		  value = "Identificador do Perfil",
		  name = "id",
		  dataType = "integer",
		  example = "23")
  private Long id;

  @ApiModelProperty(
			  value = "Nome do Perfil",
			  name = "name",
			  dataType = "String",
			  example = "COORDENADOR")
  private String name;
  
  @ApiModelProperty(
		  value = "Papel",
		  name = "papel",
		  dataType = "Object",
		  example = "COORDENADOR")
  
  private RoleModel role;
  
  @ApiModelProperty(
		  value = "Usuário",
		  name = "usuario",
		  dataType = "Object",
		  example = "COORDENADOR")
  
  private UserModel user;

public ProfileResponseModel() {
	super();
}

public ProfileResponseModel(Long id, String name, RoleModel role, UserModel user) {
	super();
	this.id = id;
	this.name = name;
	this.role = role;
	this.user = user;
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

public RoleModel getRole() {
	return role;
}

public void setRole(RoleModel role) {
	this.role = role;
}

public UserModel getUser() {
	return user;
}

public void setUser(UserModel user) {
	this.user = user;
} 
  
  
}
