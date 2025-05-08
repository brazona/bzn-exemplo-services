package br.brazona.bzn_exemplo_services_users.domain.model;


import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**Classe modelo Usuário.
* @author Brazona Tech
* @version 1.0.0
* @since release 1.0.0
*/

@Component
@ApiModel(description = "Modelo objeto Usuário")
public class UserModel {

	@ApiModelProperty(
			  value = "Identificador do Usuário",
			  name = "id",
			  dataType = "integer",
			  example = "23")
    private Long id;
	@ApiModelProperty(
			  value = "Email do Usuário",
			  name = "email",
			  dataType = "String",
			  example = "exemplo@exemplo.com.br")
    private String email;

    public UserModel() {
    }

    
    public UserModel(Long id, String email) {
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
