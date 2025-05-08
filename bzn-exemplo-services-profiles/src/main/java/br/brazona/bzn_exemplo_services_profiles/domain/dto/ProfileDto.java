package br.brazona.bzn_exemplo_services_profiles.domain.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.brazona.bzn_exemplo_services_profiles.BznExemploServicesProfilesApplication;
import br.brazona.bzn_exemplo_services_profiles.infra.entities.ProfilesEntity;
import br.brazona.bzn_exemplo_services_profiles.model.v1.Profile;

@Component
public class ProfileDto {

    ProfileDto(BznExemploServicesProfilesApplication bznExemploServicesProfilesApplication) {
    }
    
    @Autowired
    private ProfilesEntity profilesEntity;
	
	public Profile toModel (ProfilesEntity entity) {
		
		return new Profile()
				.id(entity.getId())
				.name(entity.getName())
				.roleId(entity.getRoleId());
	};
	
	public ProfilesEntity toEntity(Profile model) {
		profilesEntity.setId(model.getId());
		profilesEntity.setName(model.getName());
		profilesEntity.setRoleId(model.getRoleId());
		profilesEntity.setUserId(model.getUserId());
		return profilesEntity;
	}

}
