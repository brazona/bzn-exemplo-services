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
public class ProfileModel {
	
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
		  value = "Identificador do Usuário",
		  name = "userId",
		  dataType = "integer",
		  example = "1")
private Integer userId;
  
  @ApiModelProperty(
		  value = "Identificador do Papel",
		  name = "roleId",
		  dataType = "integer",
		  example = "1")
private Integer roleId;

  
public ProfileModel() {
	super();
}

public ProfileModel(Long id, String name, Integer userId, Integer roleId) {
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


  
  
}
