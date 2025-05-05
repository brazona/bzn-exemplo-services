package br.brazona.bzn_exemplo_services_users.infra.repositories;

import br.brazona.bzn_exemplo_services_users.domain.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Long> {
}
