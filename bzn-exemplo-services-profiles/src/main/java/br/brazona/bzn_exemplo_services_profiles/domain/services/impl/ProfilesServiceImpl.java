package br.brazona.bzn_exemplo_services_profiles.domain.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.brazona.bzn_exemplo_services_profiles.domain.dto.ProfileDto;
import br.brazona.bzn_exemplo_services_profiles.domain.model.ProfileRequestModel;
import br.brazona.bzn_exemplo_services_profiles.domain.model.ProfileResponseModel;
import br.brazona.bzn_exemplo_services_profiles.domain.model.RoleModel;
import br.brazona.bzn_exemplo_services_profiles.domain.model.UserModel;
import br.brazona.bzn_exemplo_services_profiles.domain.services.IProfilesService;
import br.brazona.bzn_exemplo_services_profiles.domain.services.feign.RoleFeignClient;
import br.brazona.bzn_exemplo_services_profiles.domain.services.feign.UserFeignClient;
import br.brazona.bzn_exemplo_services_profiles.infra.entities.ProfilesEntity;
import br.brazona.bzn_exemplo_services_profiles.infra.repositories.ProfileRepository;


@Service
public class ProfilesServiceImpl implements IProfilesService{

    @Autowired
    private ProfileRepository profileRepository;
    
    @Autowired
    private UserFeignClient userFeignClient;
    
    @Autowired
    private RoleFeignClient roleFeignClient;
    
    @Autowired
    private ProfileDto profileDto;

    /**Método que cria um perfil no sistema.
     * @param profileModel - Objeto que contém as informações do perfil a ser criado no sistema.
     * @return ProfileModel - Retorna o perfil criado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao criar o perfil.
     */
    public ProfileResponseModel create(ProfileRequestModel profileModel) {
    	
    	UserModel user = userFeignClient.readById(profileModel.getUserId()).getBody();
    	RoleModel role = roleFeignClient.readById(profileModel.getRoleId()).getBody();
    	
    	ProfilesEntity entity = profileRepository.save(profileDto.toEntity(profileModel));
    	
    	
    	return readById(entity.getId());
    }
    /**Método que busca um perfil no sistema pelo id.
     * @param id - Identificador do perfil a ser buscado no sistema.
     * @return ProfileModel - Retorna o perfil encontrado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao buscar o perfil.
     */
    public ProfileResponseModel readById (Long id){
        Optional<ProfilesEntity> profilesEntityOptional = profileRepository.findById(id);
        if (profilesEntityOptional.isEmpty())
            throw new RuntimeException("Not found");
        ProfilesEntity entity = profilesEntityOptional.get();   
    	UserModel user = userFeignClient.readById(entity.getUserId()).getBody();
    	RoleModel role = roleFeignClient.readById(entity.getRoleId()).getBody();
    	
    	return profileDto.toResponseModel(
    				entity,
    				user,
    				role
    			);
    }
    
    /**Método que atualiza um perfil no sistema.
     * @param id - Identificador do perfil a ser atualizado no sistema.
     * @param profileModel - Objeto que contém as informações do perfil a ser atualizado no sistema.
     * @return ProfileModel - Retorna o perfil atualizado no sistema.
     * @throws Exception - Lança exceção caso ocorra erro ao atualizar o perfil.
     */
    public ProfileResponseModel update(Long id, ProfileRequestModel profileModel) {
    	
    	readById(id);
    	
    	ProfilesEntity entity = profileDto.toEntity(profileModel);
    	entity.setId(id);
    	profileRepository.save(entity);
    	UserModel user = userFeignClient.readById(profileModel.getUserId()).getBody();
    	RoleModel role = roleFeignClient.readById(profileModel.getRoleId()).getBody();
    	
    	return profileDto.toResponseModel(
				entity,
				user,
				role
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
	@Override
	public List<ProfileResponseModel> readALL() {
    	List<ProfileResponseModel> lista = new ArrayList<>();
    	Iterable<ProfilesEntity> iterable = profileRepository.findAll();
    	iterable.forEach(entity ->{
    		lista.add(readById(entity.getId()));
    	});
    	return lista;
	}
}