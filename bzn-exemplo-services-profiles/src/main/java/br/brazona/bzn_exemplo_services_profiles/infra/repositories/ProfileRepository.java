package br.brazona.bzn_exemplo_services_profiles.infra.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.brazona.bzn_exemplo_services_profiles.infra.entities.ProfilesEntity;

/**
 * Interface que representa o repositório de perfis.
 * @author Brazona Tech
 * @version 1.0.0
 * @since release 1.0.0
 */
@Repository
public interface ProfileRepository extends CrudRepository<ProfilesEntity, Long> {

}
