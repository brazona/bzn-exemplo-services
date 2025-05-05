package br.brazona.bzn_exemplo_services_b.infra.repositories;

import br.brazona.bzn_exemplo_services.domain.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Long> {
}
