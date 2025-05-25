package br.brazona.bzn_exemplo_services_roles.domain.dto;


import br.brazona.bzn_exemplo_services_roles.domain.models.RolesModel;
import br.brazona.bzn_exemplo_services_roles.infra.entities.RolesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RolesDTO {
    @Autowired
    private RolesModel model;
    @Autowired
    private RolesEntity entity;

    public RolesModel toModel(RolesEntity rolesEntity){
        model.setId(rolesEntity.getId());
        model.setName(rolesEntity.getName());
        return model;
    }

    public RolesEntity toEntity(RolesModel rolesModel){
        entity.setId(rolesModel.getId());
        entity.setName(rolesModel.getName());
        return entity;
    }
    public List<RolesModel> toListModel(List<RolesEntity> rolesEntityList) {
        List<RolesModel> list = new ArrayList<>();
        rolesEntityList.forEach(rolesEntity -> {
            list.add(toModel(rolesEntity));
        });
        return list;
    }
}
