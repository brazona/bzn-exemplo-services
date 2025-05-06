package br.brazona.bzn_exemplo_services_roles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@EntityScan(basePackages = { "br.brazona.bzn_exemplo_services_roles.infra.entities" })
@ComponentScan( basePackages = {"br.brazona.bzn_exemplo_services_roles.*"})
@EnableJpaRepositories(basePackages = {"br.brazona.bzn_exemplo_services_roles.infra.repositories"})
@EnableTransactionManagement
@EnableDiscoveryClient
@SpringBootApplication
public class  BznExemploServicesRolesApplication{

	public static void main(String[] args) {
		SpringApplication.run(BznExemploServicesRolesApplication.class, args);
	}

}
