package br.brazona.bzn_exemplo_services_roles.domain.models;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;


@Component
@Schema(description = "Modelo objeto Papel")
public class RolesModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Schema( description = "Identificador do Papel",
			  name = "id",
			  contentMediaType = "integer",
			  example = "23")
	private Long id;
	@Schema(
			  description = "Nome Papel",
			  name = "name",
			  contentMediaType = "String",
			  example = "ROLE_GUEST")
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
