package br.brazona.bzn_exemplo_services_roles.domain.dto;


import br.brazona.bzn_exemplo_services_roles.domain.models.RolesModel;
import br.brazona.bzn_exemplo_services_roles.infra.entities.RolesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**Classe responsável por transforma dados dos Papeis.
* @author Brazona Tech
* @version 1.0.0
* @since release 1.0.0
*/

@Component
public class RolesDTO {
    @Autowired
    private RolesModel model;
    @Autowired
    private RolesEntity entity;

    /**Método que transforma dados da classe Entidade para Modelo.
     * @param rolesEntity - Objeto que contém as informações da entidade papel.
     * @return RolesModel - Retorna objeto modelo com as informações do papel.
     */
    public RolesModel toModel(RolesEntity rolesEntity){
        return new RolesModel(rolesEntity.getId(), rolesEntity.getName());
    }

    /**Método que transforma dados da classe Modelo para Entidade.
     * @param rolesModel - Objeto que contém as informações da entidade papel.
     * @return RolesEntity - Retorna objeto entidade com as informações do papel.
     */
    public RolesEntity toEntity(RolesModel rolesModel){
        return new RolesEntity(rolesModel.getId(), rolesModel.getName());
    }
}
