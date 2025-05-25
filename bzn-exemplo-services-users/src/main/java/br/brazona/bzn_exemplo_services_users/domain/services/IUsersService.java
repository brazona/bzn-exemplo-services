package br.brazona.bzn_exemplo_services_users.domain.services;

import java.util.List;

import br.brazona.bzn_exemplo_services_users.domain.model.UserModel;

public interface IUsersService {
	
		
    /**Método que cria um usuário no sistema.
     * @param usersModel - Objeto que contém as informações do usuário a ser criado no sistema.
     * @return UserModel - Retorna o usuário criado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao criar o usuário.
     */
    UserModel create(UserModel userModel);
    
    /**Método que busca um usuário no sistema pelo id.
     * @param id - Identificador do usuário a ser buscado no sistema.
     * @return UserModel - Retorna o usuário encontrado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao buscar o usuário.
     */
    UserModel readById(Long id);
    
    /**Método que atualiza um usuário no sistema.
     * @param id - Identificador do usuário a ser atualizado no sistema.
     * @param usersModel - Objeto que contém as informações do usuário a ser atualizado no sistema.
     * @return UserModel - Retorna o usuário atualizado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao atualizar o usuário.
     */
    UserModel update(Long id, UserModel userModel);
    
    /**Método que deleta um usuário no sistema.
     * @param id - Identificador do usuário a ser deletado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao deletar o usuário.
     */
    void delete(Long id);
    
    /**Método que busca todos os usuários no sistema.
     * @return List<UserModel> - Retorna a lista de usuários encontrados no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao buscar os usuários.
     */
    List<UserModel> readALL();

    

}
