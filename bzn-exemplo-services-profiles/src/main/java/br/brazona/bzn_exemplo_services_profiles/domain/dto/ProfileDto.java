package br.brazona.bzn_exemplo_services_profiles.domain.dto;


import org.springframework.stereotype.Component;

import br.brazona.bzn_exemplo_services_profiles.domain.model.ProfileRequestModel;
import br.brazona.bzn_exemplo_services_profiles.domain.model.ProfileResponseModel;
import br.brazona.bzn_exemplo_services_profiles.domain.model.RoleModel;
import br.brazona.bzn_exemplo_services_profiles.domain.model.UserModel;
import br.brazona.bzn_exemplo_services_profiles.infra.entities.ProfilesEntity;


@Component
public class ProfileDto {


	public ProfileResponseModel toResponseModel (ProfilesEntity entity, UserModel user, RoleModel role) {
		return new ProfileResponseModel(
						entity.getId(),
						entity.getName(),
						role,
						user
					);
	};
	
	public ProfileRequestModel toModel (ProfilesEntity entity) {
		return new ProfileRequestModel(
					entity.getId(),
					entity.getName(),
					entity.getUserId(),
					entity.getRoleId());
	};
	
	public ProfilesEntity toEntity(ProfileRequestModel model) {
		return new ProfilesEntity(
				model.getId(),
				model.getName(),
				model.getUserId(),
				model.getRoleId());
	}

}
