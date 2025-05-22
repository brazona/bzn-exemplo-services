package br.brazona.bzn_exemplo_services_profiles.application.controllers.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.brazona.bzn_exemplo_services_profiles.application.controllers.IProfilesController;
import br.brazona.bzn_exemplo_services_profiles.domain.model.ProfileModel;
import br.brazona.bzn_exemplo_services_profiles.domain.services.ProfilesService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(value = "/profiles/v1")
public class ProfilesControllerImpl implements IProfilesController{

	Logger logger = LoggerFactory.getLogger(ProfilesControllerImpl.class);
	
	@Autowired
	private ProfilesService profilesServiceImpl;
	
	/** { @inheritDoc } */
	@Override
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE
    , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfileModel> create(ProfileModel profilesModel) {
		// TODO Auto-generated method stub
		logger.trace("A TRACE body {}: ", profilesModel);
		logger.info("A INFO body {}: ", profilesModel);
		return ResponseEntity.ok(profilesServiceImpl.create(profilesModel));
	}

	/** { @inheritDoc } */
	@Override
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfileModel> readById(Long id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(profilesServiceImpl.readById(id));
	}

	/** { @inheritDoc } */
	@Override
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfileModel> update(Long id, ProfileModel profilesModel) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(profilesServiceImpl.update(id, profilesModel));
	}

	/** { @inheritDoc } */
	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(Long id) {
		// TODO Auto-generated method stub
		profilesServiceImpl.delete(id);
		return null;
	}

	/** { @inheritDoc } */
	@Override
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProfileModel>> readAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(profilesServiceImpl.readAll());
	}

    }
