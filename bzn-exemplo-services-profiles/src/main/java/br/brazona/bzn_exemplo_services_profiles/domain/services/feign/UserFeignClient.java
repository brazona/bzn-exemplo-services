package br.brazona.bzn_exemplo_services_profiles.domain.services.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.brazona.bzn_exemplo_services_profiles.domain.model.UserModel;

@Component
@FeignClient(name = "bzn-exemplo-services-users", path = "/user/v1")
public interface UserFeignClient {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<UserModel> readById(@PathVariable Long  id);

}
