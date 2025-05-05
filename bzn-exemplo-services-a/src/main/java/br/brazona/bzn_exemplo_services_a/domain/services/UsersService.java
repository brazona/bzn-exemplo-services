package br.brazona.bzn_exemplo_services_a.domain.services;

import br.brazona.bzn_exemplo_services.domain.entities.UsersEntity;
import br.brazona.bzn_exemplo_services.infra.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersEntity get (Long id){
        Optional<UsersEntity> usersEntity = usersRepository.findById(id);
        if (usersEntity.isEmpty())
            throw new RuntimeException("Not found");
        return usersEntity.get();
    }
}
