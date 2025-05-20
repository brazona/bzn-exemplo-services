package br.brazona.bzn_exemplo_services_roles.application.controllers.impl;

import br.brazona.bzn_exemplo_services_roles.application.controllers.IRolesConntroller;
import br.brazona.bzn_exemplo_services_roles.domain.models.RolesModel;
import br.brazona.bzn_exemplo_services_roles.domain.services.impl.RolesServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(value = "/roles/v1")
public class RolesControllerImpl implements IRolesConntroller{

	Logger logger = LoggerFactory.getLogger(RolesControllerImpl.class);
	
	@Autowired
	private RolesServiceImpl rolesServiceImpl;
	
	/** { @inheritDoc } */
	@Override
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE
    , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolesModel> create(RolesModel rolesModel) {
		// TODO Auto-generated method stub
		logger.trace("A TRACE body {}: ", rolesModel);
		logger.info("A INFO body {}: ", rolesModel);
		return ResponseEntity.ok(rolesServiceImpl.create(rolesModel));
	}

	/** { @inheritDoc } */
	@Override
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolesModel> readById(Long id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(rolesServiceImpl.getById(id));
	}

	/** { @inheritDoc } */
	@Override
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolesModel> update(Long id, RolesModel rolesModel) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(rolesServiceImpl.update(id, rolesModel));
	}

	/** { @inheritDoc } */
	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(Long id) {
		// TODO Auto-generated method stub
		rolesServiceImpl.delete(id);
		return null;
	}

	/** { @inheritDoc } */
	@Override
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RolesModel>> readAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(rolesServiceImpl.getALL());
	}

    }
