package br.brazona.bzn_exemplo_services_users.application.controllers;

import br.brazona.bzn_exemplo_services_users.domain.model.UserModel;
import br.brazona.bzn_exemplo_services_users.domain.services.UsersService;
import br.brazona.bzn_exemplo_services_users.infra.entities.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity>get(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(usersService.getById(id));
    }
    @GetMapping(value = "/{id}/copy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel>getByIdCopy(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(usersService.getByIdCopy(id));
    }
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserEntity>>getAll(){
        return ResponseEntity.ok(usersService.getAll());
    }
}
