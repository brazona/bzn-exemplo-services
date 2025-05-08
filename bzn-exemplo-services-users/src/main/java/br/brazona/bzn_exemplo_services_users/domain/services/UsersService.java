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

/**Classe que fornece o serviço da funcionaliade Usuário.
* @author Brazona Tech
* @version 1.0.0
* @since release 1.0.0
*/

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserModel userModel;
    
    @Autowired
    private UserDto userDto;

    /**Método que cria um usuário no sistema.
     * @param usersModel - Objeto que contém as informações do usuário a ser criado no sistema.
     * @return UserModel - Retorna o usuário criado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao criar o usuário.
     */
    public UserModel create(UserModel usersModel) {
    	return userDto.toModel(
    			usersRepository.save(userDto.toEntity(usersModel))
    			);
    }
    /**Método que busca um usuário no sistema pelo id.
     * @param id - Identificador do usuário a ser buscado no sistema.
     * @return UserModel - Retorna o usuário encontrado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao buscar o usuário.
     */
    public UserModel readById (Long id){
        Optional<UserEntity> usersEntityOptional = usersRepository.findById(id);
        if (usersEntityOptional.isEmpty())
            throw new RuntimeException("Not found");
        UserEntity usersEntity = usersEntityOptional.get();        
        return userDto.toModel(usersEntity);
    }
    
    /**Método que atualiza um usuário no sistema.
     * @param id - Identificador do usuário a ser atualizado no sistema.
     * @param usersModel - Objeto que contém as informações do usuário a ser atualizado no sistema.
     * @return UserModel - Retorna o usuário atualizado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao atualizar o usuário.
     */
    public UserModel update(Long id, UserModel usersModel) {
    	readById(id);
    	usersModel.setId(id);
    	return userDto.toModel(
    			usersRepository.save(userDto.toEntity(usersModel))
    			);
    }
    /**Método que deleta um usuário no sistema.
     * @param id - Identificador do usuário a ser deletado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao deletar o usuário.
     */
    public void delete (Long id){
    	readById(id);
    	usersRepository.deleteById(id);
    }

    /**Método que busca todos os usuários no sistema.
     * @return List<UserModel> - Retorna a lista de usuários encontrados no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao buscar os usuários.
     */
    public List<UserModel>readAll(){
    	List<UserModel> lista = new ArrayList<>();
    	Iterable<UserEntity> iterable = usersRepository.findAll();
    	iterable.forEach(entity ->{
    		lista.add(userDto.toModel(entity));
    	});
    	return lista;
    }
        
}
