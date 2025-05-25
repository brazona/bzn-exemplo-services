package br.brazona.bzn_exemplo_services_users.application.controllers.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.brazona.bzn_exemplo_services_users.application.controllers.IUsersController;
import br.brazona.bzn_exemplo_services_users.domain.model.UserModel;
import br.brazona.bzn_exemplo_services_users.domain.services.impl.UsersServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;

/** Classe que implementa IUsersController. */

@RestController
@RequestMapping(value = "/user/v1")

public class UsersControllerImpl implements IUsersController{
	
	Logger logger = LoggerFactory.getLogger(UsersControllerImpl.class);
	
	@Autowired
	private UsersServiceImpl usersService;
	
	/** { @inheritDoc } */
	@Override
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE
    , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> create(@RequestBody UserModel userModel) {
		// TODO Auto-generated method stub
		logger.trace("A TRACE body {}: ", userModel);
		logger.info("A INFO body {}: ", userModel);
		return ResponseEntity.ok(usersService.create(userModel));
	}
	/** { @inheritDoc } */
	@Override
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> readById(@PathVariable Long  id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(usersService.readById(id));
	}
	/** { @inheritDoc } */
	@Override
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> update(@PathVariable Long id, @RequestBody UserModel userModel) {
		// TODO Auto-generated method stub
		
		return ResponseEntity.ok(usersService.update(id, userModel));
	}
	/** { @inheritDoc } */
	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		usersService.delete(id);
		return null;
	}
	/** { @inheritDoc } */
	@Override
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserModel>> readAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(usersService.readALL());
	}

}
