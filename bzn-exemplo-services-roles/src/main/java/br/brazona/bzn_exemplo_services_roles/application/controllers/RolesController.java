package br.brazona.bzn_exemplo_services_roles.application.controllers;

import br.brazona.bzn_exemplo_services_roles.domain.models.RolesModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/roles/v1")
public interface RolesController {

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RolesModel> getById(@PathVariable(value = "id") Long id);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<RolesModel>> getAll();

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE
            , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RolesModel> create(@RequestBody RolesModel rolesModel);

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE
            , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RolesModel> update(@PathVariable(value = "id") Long id, @RequestBody RolesModel rolesModel);

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable(value = "id") Long id);
}
