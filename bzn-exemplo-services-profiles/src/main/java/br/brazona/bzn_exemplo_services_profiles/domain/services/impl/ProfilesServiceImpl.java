package br.brazona.bzn_exemplo_services_profiles.domain.services.impl;

import br.brazona.bzn_exemplo_services_profiles.domain.dto.RolesDTO;
import br.brazona.bzn_exemplo_services_profiles.domain.models.RolesModel;
import br.brazona.bzn_exemplo_services_profiles.domain.services.RolesServices;
import br.brazona.bzn_exemplo_services_profiles.infra.entities.RolesEntity;
import br.brazona.bzn_exemplo_services_profiles.infra.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfilesServiceImpl implements ProfilesServices {

    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private RolesDTO rolesDTO;

    @Override
    public RolesModel getById(Long id) {
        Optional<RolesEntity> rolesEntity = rolesRepository.findById(id);
        if (rolesEntity.isEmpty())
            throw new RuntimeException("Not found");
        return rolesDTO.toModel(rolesEntity.get());
    }

    @Override
    public RolesModel create(RolesModel rolesModel) {
        RolesEntity rolesEntitySaved = rolesRepository.save(rolesDTO.toEntity(rolesModel));
        return rolesDTO.toModel(rolesEntitySaved);
    }

    @Override
    public RolesModel update(Long id, RolesModel rolesModel) {
        RolesModel rolesModelUpdate = getById(id);
        rolesModelUpdate.setId(id);
        rolesModelUpdate.setName(rolesModel.getName());
        RolesEntity rolesEntitySaved = rolesRepository.save(rolesDTO.toEntity(rolesModelUpdate));
        return rolesDTO.toModel(rolesEntitySaved);
    }

    @Override
    public List<RolesModel> getALL() {

        List<RolesEntity> list = new ArrayList<>();
        Iterable<RolesEntity> rolesEntityIterable = rolesRepository.findAll();
        rolesEntityIterable.forEach(list::add);
        return rolesDTO.toListModel(list);
    }

    @Override
    public void delete(Long id) {

    }
}
