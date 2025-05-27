package br.brazona.bzn_exemplo_services_profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients
@EnableAutoConfiguration
@EntityScan(basePackages = { "br.brazona.bzn_exemplo_services_profiles.infra.entities" })
@ComponentScan( basePackages = {"br.brazona.bzn_exemplo_services_profiles.*"})
@EnableJpaRepositories(basePackages = {"br.brazona.bzn_exemplo_services_profiles.infra.repositories"})
@EnableTransactionManagement
@EnableDiscoveryClient
@SpringBootApplication
public class  BznExemploServicesProfilesApplication{

	public static void main(String[] args) {
		SpringApplication.run(BznExemploServicesProfilesApplication.class, args);
	}

}
