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

/**Classe para expor endpoint rest da funcionalidade Usuário.
* @author Brazona Tech
* @version 1.0.0
* @since release 1.0.0
*/


@Tag(name = "usuario", description = "Serviço que disponibiliza funcionalidade Usuário", 
externalDocs = @ExternalDocumentation(
		description = "Documentação da Exemplo Users",
		url = "https://github.com/brazona/bzn-exemplo-services/tree/main/bzn-exemplo-services-users"))
public interface IUsersController {


	 /**Método para criar um usuário no sistema.
	 * @param userModel - Objeto que contém as informações do usuário a ser criado no sistema.
	 * @return ResponseEntity<UserModel> - Retorna o usuário criado no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao criar o usuário.
	 */


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

	/**Método para consultar um usuário no sistema.
	 * @param id - Identificador do usuário a ser consultado.
	 * @return ResponseEntity<UserModel> - Retorna o usuário consultado no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao consultar o usuário.
	 */
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
	
	/**Método para atualizar um usuário no sistema.
	 * @param id - Identificador do usuário a ser atualizado.
	 * @param userModel - Objeto que contém as novas informações do usuário a ser atualizado no sistema.
	 * @return ResponseEntity<UserModel> - Retorna o usuário atualizado no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao atualizar o usuário.
	 */

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
	
	/**Método para deletar um usuário no sistema.
	 * @param id - Identificador do usuário a ser deletado.
	 * @return ResponseEntity<Void> - Retorna vazio caso o usuário seja deletado com sucesso.
	 * @throws Exception - Lança exceção caso ocorra erro ao deletar o usuário.
	 */
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
	
	/**Método para consultar todos os usuários no sistema.
	 * @return ResponseEntity<List<UserModel>> - Retorna a lista de usuários cadastrados no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao consultar os usuários.
	 */
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
