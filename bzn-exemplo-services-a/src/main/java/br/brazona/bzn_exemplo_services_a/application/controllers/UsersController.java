package br.brazona.bzn_exemplo_services_a.application.controllers;

import br.brazona.bzn_exemplo_services.domain.entities.UsersEntity;
import br.brazona.bzn_exemplo_services.domain.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersEntity>get(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(usersService.get(id));
    }
}
