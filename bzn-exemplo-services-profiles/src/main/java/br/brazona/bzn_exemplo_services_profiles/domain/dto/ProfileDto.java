package br.brazona.bzn_exemplo_services_profiles.domain.dto;


import org.springframework.stereotype.Component;
import br.brazona.bzn_exemplo_services_profiles.BznExemploServicesProfilesApplication;
import br.brazona.bzn_exemplo_services_profiles.domain.model.ProfileModel;
import br.brazona.bzn_exemplo_services_profiles.infra.entities.ProfilesEntity;


@Component
public class ProfileDto {

    ProfileDto(BznExemploServicesProfilesApplication bznExemploServicesProfilesApplication) {
    }
    
	
	public ProfileModel toModel (ProfilesEntity entity) {
		return new ProfileModel(
					entity.getId(),
					entity.getName(),
					entity.getUserId(),
					entity.getRoleId());
	};
	
	public ProfilesEntity toEntity(ProfileModel model) {
		return new ProfilesEntity(
				model.getId(),
				model.getName(),
				model.getUserId(),
				model.getRoleId());
	}

}
