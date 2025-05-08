package br.brazona.bzn_exemplo_services_users.domain.services;

import br.brazona.bzn_exemplo_services_users.domain.dto.UserDto;
import br.brazona.bzn_exemplo_services_users.domain.model.UserModel;
import br.brazona.bzn_exemplo_services_users.infra.entities.UserEntity;
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
    
    @Autowired
    private UserDto userDto;

    public UserModel create(UserModel usersModel) {
//    	UserEntity userSaved = usersRepository.save(userDto.toEntity(usersModel));
    	return userDto.toModel(
    			usersRepository.save(userDto.toEntity(usersModel))
    			);
    }
    public UserModel getByIdCopy (Long id){
        Optional<UserEntity> usersEntityOptional = usersRepository.findById(id);
        if (usersEntityOptional.isEmpty())
            throw new RuntimeException("Not found");
        UserEntity usersEntity = usersEntityOptional.get();
//       return new UserModel(usersEntity.getId(), usersEntity.getEmail());
        userModel.setId(usersEntity.getId());
        userModel.setEmail(usersEntity.getEmail());
        return userModel;
    }
    public UserEntity getById (Long id){
        Optional<UserEntity> usersEntityOptional = usersRepository.findById(id);
        if (usersEntityOptional.isEmpty())
            throw new RuntimeException("Not found");
        return usersEntityOptional.get();
    }
    public List<UserEntity> getAll(){
        List<UserEntity> list = new ArrayList<>();
        Iterable<UserEntity> usersEntityIterable = usersRepository.findAll();
        usersEntityIterable.forEach(list::add);
        return list;
    }
    
}
