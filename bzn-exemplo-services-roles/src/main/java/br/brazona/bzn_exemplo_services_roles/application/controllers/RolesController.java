package br.brazona.bzn_exemplo_services_roles.application.controllers;

import br.brazona.bzn_exemplo_services_roles.domain.models.RolesModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/roles/v1")
public class RolesController {

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RolesModel> getById(@PathVariable(value = "id") Long id){
        return null;
    };

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RolesModel>> getAll(){
        return null;
    };

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE
            , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RolesModel> create(@RequestBody RolesModel rolesModel){
        return null;
    };

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE
            , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RolesModel> update(@PathVariable(value = "id") Long id,
                                             @RequestBody RolesModel rolesModel){
        return null;
    };

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id){

    };
}
