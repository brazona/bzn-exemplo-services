package br.brazona.bzn_exemplo_services_profiles.domain.services;

import java.util.List;

import br.brazona.bzn_exemplo_services_profiles.domain.model.ProfileRequestModel;
import br.brazona.bzn_exemplo_services_profiles.domain.model.ProfileResponseModel;

public interface IProfilesService {

	
    /**Método que cria um perfil no sistema.
     * @param profileRequestModel - Objeto que contém as informações do perfil a ser criado no sistema.
     * @return ProfileResponseModel - Retorna o perfil criado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao criar o perfil.
     */
    ProfileResponseModel create(ProfileRequestModel profileRequestModel);
    
    /**Método que busca um perfil no sistema pelo id.
     * @param id - Identificador do perfil a ser buscado no sistema.
     * @return ProfileResponseModel - Retorna o perfil encontrado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao buscar o perfil.
     */
    ProfileResponseModel readById(Long id);
    
    /**Método que atualiza um perfil no sistema.
     * @param id - Identificador do perfil a ser atualizado no sistema.
     * @param profileRequestModel - Objeto que contém as informações do perfil a ser atualizado no sistema.
     * @return ProfileResponseModel - Retorna o perfil atualizado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao atualizar o perfil.
     */
    ProfileResponseModel update(Long id, ProfileRequestModel profileRequestModel);
    
    /**Método que deleta um perfil no sistema.
     * @param id - Identificador do perfil a ser deletado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao deletar o perfil.
     */
    void delete(Long id);
    
    /**Método que busca todos os perfils no sistema.
     * @return List<ProfileResponseModel> - Retorna a lista de perfils encontrados no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao buscar os perfils.
     */
    List<ProfileResponseModel> readALL();
}
