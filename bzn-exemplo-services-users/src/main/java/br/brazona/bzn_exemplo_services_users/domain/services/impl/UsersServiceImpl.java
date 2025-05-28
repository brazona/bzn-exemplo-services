package br.brazona.bzn_exemplo_services_users.domain.services.impl;

import br.brazona.bzn_exemplo_services_users.domain.dto.UserDto;
import br.brazona.bzn_exemplo_services_users.domain.model.UserModel;
import br.brazona.bzn_exemplo_services_users.domain.services.IUsersService;
import br.brazona.bzn_exemplo_services_users.infra.entities.UserEntity;
import br.brazona.bzn_exemplo_services_users.infra.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**Classe que fornece o serviço da funcionaliade Usuário.
* @author Brazona Tech
* @version 1.0.0
* @since release 1.0.0
*/

@Service
public class UsersServiceImpl implements IUsersService{

    @Autowired
    private UsersRepository usersRepository;
    
    @Autowired
    private UserDto userDto;

    /** { @inheritDoc } */
    @Override
    public UserModel create(UserModel usersModel) {
    	return userDto.toModel(
    				usersRepository.save(userDto.toEntity(usersModel)));
    }
    
    /** { @inheritDoc } */
    @Override
    public UserModel readById (Long id){
        Optional<UserEntity> usersEntityOptional = usersRepository.findById(id);
        if (usersEntityOptional.isEmpty())
            throw new RuntimeException("Not found");
        UserEntity usersEntity = usersEntityOptional.get();        
        return userDto.toModel(usersEntity);
    }
    
    /** { @inheritDoc } */
    @Override
    public UserModel update(Long id, UserModel usersModel) {
    	readById(id);
    	
    	UserEntity entity = userDto.toEntity(usersModel);
    	entity.setId(id);
    	return userDto.toModel(usersRepository.save(entity));
    }

    /** { @inheritDoc } */
    @Override
    public void delete (Long id){
    	readById(id);
    	usersRepository.deleteById(id);
    }
    
    /** { @inheritDoc } */
	@Override
	public List<UserModel> readALL() {
    	List<UserModel> lista = new ArrayList<>();
    	Iterable<UserEntity> iterable = usersRepository.findAll();
    	iterable.forEach(entity ->{
    		lista.add(userDto.toModel(entity));
    	});
    	return lista;
	}
        
}
