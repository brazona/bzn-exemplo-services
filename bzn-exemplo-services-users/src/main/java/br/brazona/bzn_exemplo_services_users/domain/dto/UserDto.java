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
	 * @param userEntity - Objeto que contém as informações da entidade usuário.
	 * @return UserModel - Retorna objeto modelo com as informações do usuário.
	 */	

	public UserModel toModel(UserEntity userEntity) {
		return new UserModel(userEntity.getId(), userEntity.getEmail());
	}
	/**Método que transforma dados da classe Modelo para Entidade.
	 * @param userModel - Objeto que contém as informações da entidade usuário.
	 * @return UserEntity - Retorna objeto entidade com as informações do usuário.
	 */	
	public UserEntity toEntity(UserModel userModel) {
		return new UserEntity(userModel.getEmail());
	}
}
