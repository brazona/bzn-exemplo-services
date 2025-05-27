package br.brazona.bzn_exemplo_services_profiles.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.brazona.bzn_exemplo_services_profiles.domain.model.ProfileRequestModel;
import br.brazona.bzn_exemplo_services_profiles.domain.model.ProfileResponseModel;
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

/**Classe para expor endpoint rest da funcionalidade Perfils..
* @author Brazona Tech
* @version 1.0.0
* @since release 1.0.0
*/


@Tag(name = "perfis", description = "Serviço que disponibiliza funcionalidade Perfis", 
externalDocs = @ExternalDocumentation(
		description = "Documentação da Exemplo Profiles",
		url = "https://github.com/brazona/bzn-exemplo-services/tree/main/bzn-exemplo-services-profiles"))
public interface IProfilesController {

/**Método para criar um perfis no sistema.
	 * @param perfisModel - Objeto que contém as informações do perfis a ser criado no sistema.
	 * @return ResponseEntity<ProfileModel> - Retorna o perfis criado no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao criar o perfis.
	 */


	@Operation(
		summary = "Cria perfis no sistema",
		description = "Recurso que cria informações do perfis no sistema", 
		operationId = "criarPerfil",
		tags = "perfis",
		requestBody = 
			@RequestBody(
					required = true, 
					description = "Informações do Perfil", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ProfileRequestModel.class))
			),
		method = "POST",
		responses = 
			{
				@ApiResponse(
					responseCode = "200", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ProfileRequestModel.class)),
					description = "Perfil criado com sucesso!"
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
	public ResponseEntity<ProfileResponseModel>create(ProfileRequestModel perfisModel);

	/**Método para consultar um perfis no sistema.
	 * @param id - Identificador do perfis a ser consultado.
	 * @return ResponseEntity<ProfileModel> - Retorna o perfis consultado no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao consultar o perfis.
	 */
	@Operation(
			summary = "Consulta perfis pelo identificador",
			description = "Através do identificador consulta as informações do perfis cadastradas no sistema.", 
			operationId = "consultaPerfilId",
			tags = "perfis",
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
								schema = @Schema(implementation = ProfileRequestModel.class)),
						description = "Perfil localizado com sucesso!"
						),
					@ApiResponse(
							responseCode = "404",
							description = "Perfil não localizado"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	public ResponseEntity<ProfileResponseModel>readById(Long id);
	
	/**Método para atualizar um perfis no sistema.
	 * @param id - Identificador do perfis a ser atualizado.
	 * @param perfisModel - Objeto que contém as novas informações do perfis a ser atualizado no sistema.
	 * @return ResponseEntity<ProfileModel> - Retorna o perfis atualizado no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao atualizar o perfis.
	 */

	@Operation(
			summary = "Atualiza perfis pelo identificador ",
			description = "Através do identificador e das novas informações atualiza as informações do perfis cadastradas no sistema.", 
			operationId = "atualizaPerfilId",
			tags = "perfis",
			method = "PUT",
			requestBody = 
				@RequestBody(
						required = true, 
						description = "Informações do Perfil", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = ProfileRequestModel.class))
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
								schema = @Schema(implementation = ProfileRequestModel.class)),
						description = "Perfil atualiza com sucesso!"
						),
					@ApiResponse(
							responseCode = "400",
							description = "Formato inválido"
					),
					@ApiResponse(
							responseCode = "404",
							description = "Perfil não localizado"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	
	public ResponseEntity<ProfileResponseModel>update(Long id, ProfileRequestModel perfisModel);
	
	/**Método para deletar um perfis no sistema.
	 * @param id - Identificador do perfis a ser deletado.
	 * @return ResponseEntity<Void> - Retorna vazio caso o perfis seja deletado com sucesso.
	 * @throws Exception - Lança exceção caso ocorra erro ao deletar o perfis.
	 */
	@Operation(
			summary = "Deleta perfis pelo identificador",
			description = "Através do identificador deleta as informações do perfis cadastradas no sistema.", 
			operationId = "deletaPerfilId",
			tags = "perfis",
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
						description = "Perfil deletado com sucesso!"
						),
					@ApiResponse(
							responseCode = "404",
							description = "Perfil não localizado"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	

	public ResponseEntity<Void>delete(Long id);
	
	/**Método para consultar todos os perfis no sistema.
	 * @return ResponseEntity<List<ProfileModel>> - Retorna a lista de perfis cadastrados no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao consultar os perfis.
	 */
	@Operation(
			summary = "Consulta todos os perfis",
			description = "Consulta todos os perfis cadastradas no sistema.", 
			operationId = "listaPerfis",
			tags = "perfis",
			method = "GET",
			responses = 
				{
					@ApiResponse(
							responseCode = "200", 
							content = @Content(
									mediaType = "application/json", 
									array = @ArraySchema(schema = @Schema(implementation = ProfileRequestModel.class))),
							description = "Perfis consultados com sucesso!"
							),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	
	public ResponseEntity<List<ProfileResponseModel>>readAll();
	
	
}

