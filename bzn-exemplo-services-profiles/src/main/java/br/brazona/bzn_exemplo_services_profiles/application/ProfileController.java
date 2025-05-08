package br.brazona.bzn_exemplo_services_profiles.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import br.brazona.bzn_exemplo_services_profiles.api.v1.PerfilApi;
import br.brazona.bzn_exemplo_services_profiles.domain.services.ProfileService;
import br.brazona.bzn_exemplo_services_profiles.model.v1.Profile;
import jakarta.validation.Valid;

public class ProfileController implements PerfilApi {

	@Autowired
	private ProfileService service;

	@Override
	public Optional<NativeWebRequest> getRequest() {
		// TODO Auto-generated method stub
		return PerfilApi.super.getRequest();
	}

	@Override
	public ResponseEntity<Profile> addProfile(@Valid Profile profile) {
		// TODO Auto-generated method stub
		return PerfilApi.super.addProfile(service.create(profile));
	}

	@Override
	public ResponseEntity<Void> deleteProfileId(Long profileID) {
		// TODO Auto-generated method stub
		service.delete(profileID);
		return null;
	}

	@Override
	public ResponseEntity<List<Profile>> getProfileAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(service.getAll());

	}

	@Override
	public ResponseEntity<Profile> getProfileId(Long profileID) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(service.getById(profileID));
	}

	@Override
	public ResponseEntity<Profile> updateProfileId(Long profileID, @Valid Profile profile) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(service.update(profileID, profile));
	}

}
