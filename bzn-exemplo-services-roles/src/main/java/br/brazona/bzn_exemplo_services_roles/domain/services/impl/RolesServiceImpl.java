package br.brazona.bzn_exemplo_services_roles.domain.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.brazona.bzn_exemplo_services_roles.domain.dto.RolesDTO;
import br.brazona.bzn_exemplo_services_roles.domain.models.RolesModel;
import br.brazona.bzn_exemplo_services_roles.domain.services.IRolesServices;
import br.brazona.bzn_exemplo_services_roles.infra.entities.RolesEntity;
import br.brazona.bzn_exemplo_services_roles.infra.repositories.RolesRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** { @inheritDoc } */
@Service
public class RolesServiceImpl implements IRolesServices {

    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private RolesDTO rolesDTO;

    /** { @inheritDoc } */
    @Override
    public RolesModel readById(Long id) {
        Optional<RolesEntity> rolesEntity = rolesRepository.findById(id);
        if (rolesEntity.isEmpty())
            throw new RuntimeException("Not found");
        return rolesDTO.toModel(rolesEntity.get());
    }
    
    /** { @inheritDoc } */
    @Override
    public RolesModel create(RolesModel rolesModel) {
        RolesEntity rolesEntitySaved = rolesRepository.save(rolesDTO.toEntity(rolesModel));
        return rolesDTO.toModel(rolesEntitySaved);
    }
    
    /** { @inheritDoc } */
    @Override
    public RolesModel update(Long id, RolesModel rolesModel) {
        readById(id);
        
        RolesEntity entity = rolesDTO.toEntity(rolesModel);
    	entity.setId(id);
    	return rolesDTO.toModel(rolesRepository.save(entity));
    }

    /** { @inheritDoc } */
    @Override
    public void delete(Long id) {

    	readById(id);
    	rolesRepository.deleteById(id);
    }
    
    /** { @inheritDoc } */
    @Override
    public List<RolesModel> readALL() {

        List<RolesModel> lista = new ArrayList<>();
        Iterable<RolesEntity> rolesEntityIterable = rolesRepository.findAll();
        rolesEntityIterable.forEach(entity ->{
        	lista.add(rolesDTO.toModel(entity));
        });
        
        return lista;
    }
}
