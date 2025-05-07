package br.brazona.bzn_exemplo_services_profiles.domain.services;

import br.brazona.bzn_exemplo_services_profiles.domain.models.RolesModel;

import java.util.List;

public interface RolesServices {

    RolesModel getById(Long id);

    RolesModel create(RolesModel rolesModel);

    RolesModel update(Long id, RolesModel rolesModel);

    List<RolesModel> getALL();

    void delete(Long id);
}
