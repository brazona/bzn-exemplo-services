package br.brazona.bzn_exemplo_services_users.application.controllers.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.brazona.bzn_exemplo_services_users.application.controllers.IUsersController;
import br.brazona.bzn_exemplo_services_users.domain.model.UserModel;
import br.brazona.bzn_exemplo_services_users.domain.services.UsersService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/user/v1")

public class UsersControllerImpl implements IUsersController{
	
	Logger logger = LoggerFactory.getLogger(UsersControllerImpl.class);
	
	@Autowired
	private UsersService usersService;
	
	@Override
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE
    , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> create(@RequestBody UserModel userModel) {
		// TODO Auto-generated method stub
		logger.trace("A TRACE body {}: ", userModel);
		logger.info("A INFO body {}: ", userModel);
		return ResponseEntity.ok(usersService.create(userModel));
	}

	@Override
	public ResponseEntity<UserModel> readById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UserModel> update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<UserModel>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
