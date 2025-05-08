package br.brazona.bzn_exemplo_services_users.infra.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.brazona.bzn_exemplo_services_users.infra.entities.UserEntity;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long> {
}
