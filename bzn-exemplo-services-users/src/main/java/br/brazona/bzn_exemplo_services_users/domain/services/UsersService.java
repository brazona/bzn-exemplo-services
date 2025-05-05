package br.brazona.bzn_exemplo_services_users.domain.services;

import br.brazona.bzn_exemplo_services_users.domain.entities.UsersEntity;
import br.brazona.bzn_exemplo_services_users.domain.model.UserModel;
import br.brazona.bzn_exemplo_services_users.infra.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserModel userModel;

    public UserModel getByIdCopy (Long id){
        Optional<UsersEntity> usersEntityOptional = usersRepository.findById(id);
        if (usersEntityOptional.isEmpty())
            throw new RuntimeException("Not found");
        UsersEntity usersEntity = usersEntityOptional.get();
//       return new UserModel(usersEntity.getId(), usersEntity.getEmail());
        userModel.setId(usersEntity.getId());
        userModel.setEmail(usersEntity.getEmail());
        return userModel;
    }
    public UsersEntity getById (Long id){
        Optional<UsersEntity> usersEntityOptional = usersRepository.findById(id);
        if (usersEntityOptional.isEmpty())
            throw new RuntimeException("Not found");
        return usersEntityOptional.get();
    }
    public List<UsersEntity> getAll(){
        List<UsersEntity> list = new ArrayList<>();
        Iterable<UsersEntity> usersEntityIterable = usersRepository.findAll();
        usersEntityIterable.forEach(list::add);
        return list;
    }
}
