package br.brazona.bzn_exemplo_services_profiles.domain.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.brazona.bzn_exemplo_services_profiles.domain.dto.ProfileDto;
import br.brazona.bzn_exemplo_services_profiles.domain.services.ProfileService;
import br.brazona.bzn_exemplo_services_profiles.infra.entities.ProfilesEntity;
import br.brazona.bzn_exemplo_services_profiles.infra.repositories.ProfileRepository;
import br.brazona.bzn_exemplo_services_profiles.model.v1.Profile;

public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileDto dto;
	@Autowired
	private ProfileRepository repository;
	
	@Override
	public Profile getById(Long id) {
		// TODO Auto-generated method stub
		Optional<ProfilesEntity> profileEntityOp = repository.findById(id);
		if(profileEntityOp.isPresent())
			return dto.toModel(profileEntityOp.get());
		return null;
	}

	@Override
	public List<Profile> getAll() {
		// TODO Auto-generated method stub
		List<Profile> lista = new ArrayList<>();
		Iterable<ProfilesEntity> iterable = repository.findAll();
		iterable.forEach(entity ->{
			lista.add(dto.toModel(entity));
		});
		return lista;
	}

	@Override
	public Profile create(Profile profile) {
		// TODO Auto-generated method stub
		ProfilesEntity profilesEntitySave = repository.save(dto.toEntity(profile));
		return dto.toModel(profilesEntitySave);
	}

	@Override
	public Profile update(Long id, Profile profile) {
		// TODO Auto-generated method stub
		Optional<ProfilesEntity> profileEntityOp = repository.findById(id);
		if(!profileEntityOp.isPresent())
			return null;
		ProfilesEntity profileSave = repository.save(dto.toEntity(profile));
		
		return dto.toModel(profileSave);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Optional<ProfilesEntity> profileEntityOp = repository.findById(id);
		if(profileEntityOp.isPresent())
			repository.deleteById(id);
	
	}

}
