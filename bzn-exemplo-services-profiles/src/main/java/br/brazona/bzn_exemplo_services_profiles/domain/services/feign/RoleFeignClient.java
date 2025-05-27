package br.brazona.bzn_exemplo_services_profiles.domain.services.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.brazona.bzn_exemplo_services_profiles.domain.model.RoleModel;
import br.brazona.bzn_exemplo_services_profiles.domain.model.UserModel;

@Component
@FeignClient(name = "bzn-exemplo-services-roles", path = "/roles/v1")
public interface RoleFeignClient {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<RoleModel> readById(@PathVariable Long  id);

}
