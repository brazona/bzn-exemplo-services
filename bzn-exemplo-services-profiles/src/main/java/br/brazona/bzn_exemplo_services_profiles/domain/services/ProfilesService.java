package br.brazona.bzn_exemplo_services_profiles.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.brazona.bzn_exemplo_services_profiles.domain.dto.ProfileDto;
import br.brazona.bzn_exemplo_services_profiles.domain.model.ProfileModel;
import br.brazona.bzn_exemplo_services_profiles.infra.entities.ProfilesEntity;
import br.brazona.bzn_exemplo_services_profiles.infra.repositories.ProfileRepository;

@Service
public class ProfilesService {

    @Autowired
    private ProfileRepository profileRepository;
    
    @Autowired
    private ProfileDto profileDto;

    /**Método que cria um perfil no sistema.
     * @param profileModel - Objeto que contém as informações do perfil a ser criado no sistema.
     * @return ProfileModel - Retorna o perfil criado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao criar o perfil.
     */
    public ProfileModel create(ProfileModel profileModel) {
    	return profileDto.toModel(
    				profileRepository.save(profileDto.toEntity(profileModel))
    			);
    }
    /**Método que busca um perfil no sistema pelo id.
     * @param id - Identificador do perfil a ser buscado no sistema.
     * @return ProfileModel - Retorna o perfil encontrado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao buscar o perfil.
     */
    public ProfileModel readById (Long id){
        Optional<ProfilesEntity> profilesEntityOptional = profileRepository.findById(id);
        if (profilesEntityOptional.isEmpty())
            throw new RuntimeException("Not found");
        ProfilesEntity profilesEntity = profilesEntityOptional.get();        
        return profileDto.toModel(profilesEntity);
    }
    
    /**Método que atualiza um perfil no sistema.
     * @param id - Identificador do perfil a ser atualizado no sistema.
     * @param profileModel - Objeto que contém as informações do perfil a ser atualizado no sistema.
     * @return ProfileModel - Retorna o perfil atualizado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao atualizar o perfil.
     */
    public ProfileModel update(Long id, ProfileModel profileModel) {
    	readById(id);
    	profileModel.setId(id);
    	return profileDto.toModel(
    			profileRepository.save(profileDto.toEntity(profileModel))
    			);
    }
    /**Método que deleta um perfil no sistema.
     * @param id - Identificador do perfil a ser deletado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao deletar o perfil.
     */
    public void delete (Long id){
    	readById(id);
    	profileRepository.deleteById(id);
    }

    /**Método que busca todos os perfis no sistema.
     * @return List<ProfileModel> - Retorna a lista de perfis encontrados no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao buscar os perfis.
     */
    public List<ProfileModel>readAll(){
    	List<ProfileModel> lista = new ArrayList<>();
    	Iterable<ProfilesEntity> iterable = profileRepository.findAll();
    	iterable.forEach(entity ->{
    		lista.add(profileDto.toModel(entity));
    	});
    	return lista;
    }
}