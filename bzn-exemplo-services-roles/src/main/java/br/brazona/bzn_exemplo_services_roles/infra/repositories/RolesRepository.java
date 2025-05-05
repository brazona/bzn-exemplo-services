package br.brazona.bzn_exemplo_services_roles.infra.repositories;

import br.brazona.bzn_exemplo_services_roles.domain.entities.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<RolesEntity, Long> {
}
