package br.brazona.bzn_exemplo_services_profiles.infra.repositories;

import org.springframework.data.repository.CrudRepository;

import br.brazona.bzn_exemplo_services_profiles.infra.entities.ProfilesEntity;

public interface ProfileRepository extends CrudRepository<ProfilesEntity, Long> {

}
