package br.brazona.bzn_exemplo_services_users.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.brazona.bzn_exemplo_services_users.domain.model.UserModel;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Tag(name = "usuario", description = "Serviço que disponibiliza funcionalidade Usuário", 
externalDocs = @ExternalDocumentation(
		description = "Documentação da Exemplo Users",
		url = "https://github.com/brazona/bzn-exemplo-services/tree/main/bzn-exemplo-services-users"))
public interface IUsersController {

	@Operation(
		summary = "Cria usuário no sistema",
		description = "Recurso que cria informações do usuário no sistema", 
		operationId = "criarUsuario",
		tags = "usuario",
		requestBody = 
			@RequestBody(
					required = true, 
					description = "Informações do Usuário", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = UserModel.class))
			),
		method = "POST",
		responses = 
			{
				@ApiResponse(
					responseCode = "200", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = UserModel.class)),
					description = "Usuário criado com sucesso!"
					),
				@ApiResponse(
						responseCode = "400",
						description = "Formato inválido"
				),
				@ApiResponse(
						responseCode = "500",
						description = "Erro interno do sistema"
				)
			}	 
	)
	public ResponseEntity<UserModel>create(UserModel userModel);
	public ResponseEntity<UserModel>readById();
	public ResponseEntity<UserModel>update();
	public ResponseEntity<Void>delete();
	public ResponseEntity<List<UserModel>>readAll();
	
	
}
