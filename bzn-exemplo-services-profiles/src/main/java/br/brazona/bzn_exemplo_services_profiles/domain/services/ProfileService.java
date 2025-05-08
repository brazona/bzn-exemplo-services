package br.brazona.bzn_exemplo_services_profiles.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.brazona.bzn_exemplo_services_profiles.model.v1.Profile;

@Service
public interface ProfileService {

	Profile getById(Long id);
	List<Profile> getAll();
	Profile create(Profile profile);
	Profile update(Long id, Profile profile);
	void delete(Long id);
}
