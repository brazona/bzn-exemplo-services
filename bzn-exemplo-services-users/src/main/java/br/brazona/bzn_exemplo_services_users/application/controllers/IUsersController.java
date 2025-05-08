package br.brazona.bzn_exemplo_services_users.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.brazona.bzn_exemplo_services_users.domain.model.UserModel;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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

	@Operation(
			summary = "Consulta usuário pelo identificador",
			description = "Através do identificador consulta as informações do usuário cadastradas no sistema.", 
			operationId = "consultaUsuarioId",
			tags = "usuario",
			method = "GET",
			parameters = @Parameter(
						name = "id",
						in = ParameterIn.PATH,
						required = true,
						schema = @Schema(
								type = "integer",
								format = "int64"
								)
					),
			responses = 
				{
					@ApiResponse(
						responseCode = "200", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = UserModel.class)),
						description = "Usuário localizado com sucesso!"
						),
					@ApiResponse(
							responseCode = "404",
							description = "Usuário não localizado"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	public ResponseEntity<UserModel>readById(Long id);
	
	@Operation(
			summary = "Atualiza usuário pelo identificador ",
			description = "Através do identificador e das novas informações atualiza as informações do usuário cadastradas no sistema.", 
			operationId = "atualizaUsuario",
			tags = "usuario",
			method = "PUT",
			requestBody = 
				@RequestBody(
						required = true, 
						description = "Informações do Usuário", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = UserModel.class))
				),
			parameters = @Parameter(
						name = "id",
						in = ParameterIn.PATH,
						required = true,
						schema = @Schema(
								type = "integer",
								format = "int64"
								)
					),
			responses = 
				{
					@ApiResponse(
						responseCode = "200", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = UserModel.class)),
						description = "Usuário atualiza com sucesso!"
						),
					@ApiResponse(
							responseCode = "400",
							description = "Formato inválido"
					),
					@ApiResponse(
							responseCode = "404",
							description = "Usuário não localizado"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	
	public ResponseEntity<UserModel>update(Long id, UserModel userModel);
	
	@Operation(
			summary = "Deleta usuário pelo identificador",
			description = "Através do identificador deleta as informações do usuário cadastradas no sistema.", 
			operationId = "deletaUsuarioId",
			tags = "usuario",
			method = "DELETE",
			parameters = @Parameter(
						name = "id",
						in = ParameterIn.PATH,
						required = true,
						schema = @Schema(
								type = "integer",
								format = "int64"
								)
					),
			responses = 
				{
					@ApiResponse(
						responseCode = "200", 
						description = "Usuário deletado com sucesso!"
						),
					@ApiResponse(
							responseCode = "404",
							description = "Usuário não localizado"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	

	public ResponseEntity<Void>delete(Long id);
	
	@Operation(
			summary = "Consulta todos os usuário",
			description = "Consulta todos os usuários cadastradas no sistema.", 
			operationId = "listaUsuario",
			tags = "usuario",
			method = "GET",
			responses = 
				{
					@ApiResponse(
							responseCode = "200", 
							content = @Content(
									mediaType = "application/json", 
									array = @ArraySchema(schema = @Schema(implementation = UserModel.class))),
							description = "Usuários consultados com sucesso!"
							),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	
	public ResponseEntity<List<UserModel>>readAll();
	
	
}
