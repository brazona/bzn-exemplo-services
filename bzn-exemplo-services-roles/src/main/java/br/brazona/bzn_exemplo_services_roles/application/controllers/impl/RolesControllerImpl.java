package br.brazona.bzn_exemplo_services_roles.application.controllers.impl;

import br.brazona.bzn_exemplo_services_roles.application.controllers.RolesController;
import br.brazona.bzn_exemplo_services_roles.domain.models.RolesModel;
import br.brazona.bzn_exemplo_services_roles.domain.services.impl.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class RolesControllerImpl implements RolesController {

    @Autowired
    private RolesServiceImpl rolesService;


    @Override
    public ResponseEntity<RolesModel> getById(Long id) {
        return ResponseEntity.ok(rolesService.getById(id));
    }

    @Override
    public ResponseEntity<List<RolesModel>> getAll() {
        return ResponseEntity.ok(rolesService.getALL());
    }

    @Override
    public ResponseEntity<RolesModel> create(RolesModel rolesModel) {
        return ResponseEntity.ok(rolesService.create(rolesModel));
    }

    @Override
    public ResponseEntity<RolesModel> update(Long id, RolesModel rolesModel) {
        return ResponseEntity.ok(rolesService.update(id, rolesModel));
    }

    @Override
    public void delete(Long id) {
        rolesService.delete(id);
    }
}
