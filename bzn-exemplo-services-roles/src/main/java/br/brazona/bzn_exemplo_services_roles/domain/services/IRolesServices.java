package br.brazona.bzn_exemplo_services_roles.domain.services;

import br.brazona.bzn_exemplo_services_roles.domain.models.RolesModel;

import java.util.List;

/**Classe que fornece o serviço da funcionaliade Papel.
* @author Brazona Tech
* @version 1.0.0
* @since release 1.0.0
*/
public interface IRolesServices {

    
    /**Método que cria um papel no sistema.
     * @param rolesModel - Objeto que contém as informações do papel a ser criado no sistema.
     * @return RolesModel - Retorna o papel criado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao criar o papel.
     */
    RolesModel create(RolesModel rolesModel);
    
    /**Método que busca um papel no sistema pelo id.
     * @param id - Identificador do papel a ser buscado no sistema.
     * @return RolesModel - Retorna o papel encontrado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao buscar o papel.
     */
    RolesModel readById(Long id);
    
    /**Método que atualiza um papel no sistema.
     * @param id - Identificador do papel a ser atualizado no sistema.
     * @param rolesModel - Objeto que contém as informações do papel a ser atualizado no sistema.
     * @return RolesModel - Retorna o papel atualizado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao atualizar o papel.
     */
    RolesModel update(Long id, RolesModel rolesModel);
    
    /**Método que deleta um papel no sistema.
     * @param id - Identificador do papel a ser deletado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao deletar o papel.
     */
    void delete(Long id);
    
    /**Método que busca todos os papeis no sistema.
     * @return List<RolesModel> - Retorna a lista de papeis encontrados no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao buscar os papeis.
     */
    List<RolesModel> readALL();

    
}
