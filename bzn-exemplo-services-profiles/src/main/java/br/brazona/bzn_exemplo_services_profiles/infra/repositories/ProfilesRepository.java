package br.brazona.bzn_exemplo_services_profiles.infra.repositories;

import br.brazona.bzn_exemplo_services_profiles.infra.entities.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilesRepository extends CrudRepository<RolesEntity, Long> {
}
