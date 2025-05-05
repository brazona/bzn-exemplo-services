package br.brazona.bzn_exemplo_services_roles.application.controllers;

import br.brazona.bzn_exemplo_services_roles.domain.entities.RolesEntity;
import br.brazona.bzn_exemplo_services_roles.domain.services.RolesService;
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
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RolesEntity>getById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(rolesService.getById(id));
    }
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RolesEntity>>getAll(){
        return ResponseEntity.ok(rolesService.getAll());
    }
}
