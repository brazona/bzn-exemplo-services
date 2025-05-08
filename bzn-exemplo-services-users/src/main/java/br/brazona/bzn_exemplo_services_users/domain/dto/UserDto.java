package br.brazona.bzn_exemplo_services_users.domain.dto;

import org.springframework.stereotype.Component;

import br.brazona.bzn_exemplo_services_users.domain.model.UserModel;
import br.brazona.bzn_exemplo_services_users.infra.entities.UserEntity;

/**Classe responsável por transforma dados dos Usuários.
* @author Brazona Tech
* @version 1.0.0
* @since release 1.0.0
*/

@Component
public class UserDto {

	 /**Método que transforma dados da classe Entidade para Modelo.
	 * @param entity - Objeto que contém as informações da entidade usuário.
	 * @return UserModel - Retorna objeto modelo com as informações do usuário.
	 */	

	public UserModel toModel(UserEntity entity) {
		return new UserModel(entity.getId(), entity.getEmail());
	}
	/**Método que transforma dados da classe Modelo para Entidade.
	 * @param model - Objeto que contém as informações da entidade usuário.
	 * @return UserEntity - Retorna objeto entidade com as informações do usuário.
	 */	
	public UserEntity toEntity(UserModel model) {
		return new UserEntity(model.getId(), model.getEmail());
	}
}
