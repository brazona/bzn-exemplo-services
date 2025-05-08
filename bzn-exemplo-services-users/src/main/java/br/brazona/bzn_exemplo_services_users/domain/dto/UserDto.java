package br.brazona.bzn_exemplo_services_users.domain.dto;

import org.springframework.stereotype.Component;

import br.brazona.bzn_exemplo_services_users.domain.model.UserModel;
import br.brazona.bzn_exemplo_services_users.infra.entities.UserEntity;

@Component
public class UserDto {
	
	public UserModel toModel(UserEntity entity) {
		return new UserModel(entity.getId(), entity.getEmail());
	}
	public UserEntity toEntity(UserModel model) {
		return new UserEntity(model.getId(), model.getEmail());
	}
}
