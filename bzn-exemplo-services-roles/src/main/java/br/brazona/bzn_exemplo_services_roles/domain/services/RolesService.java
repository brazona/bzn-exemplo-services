package br.brazona.bzn_exemplo_services_roles.domain.services;

import br.brazona.bzn_exemplo_services_roles.domain.entities.RolesEntity;
import br.brazona.bzn_exemplo_services_roles.infra.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public RolesEntity getById (Long id){
        Optional<RolesEntity> rolesEntity = rolesRepository.findById(id);
        if (rolesEntity.isEmpty())
            throw new RuntimeException("Not found");
        return rolesEntity.get();
    }
    public List<RolesEntity> getAll(){
        List<RolesEntity> list = new ArrayList<>();
        Iterable<RolesEntity> rolesEntityIterable = rolesRepository.findAll();
        rolesEntityIterable.forEach(list::add);
        return list;
    }
}
