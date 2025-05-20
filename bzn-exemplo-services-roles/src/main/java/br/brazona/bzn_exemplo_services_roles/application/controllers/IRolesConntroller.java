package br.brazona.bzn_exemplo_services_roles.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.brazona.bzn_exemplo_services_roles.domain.models.RolesModel;
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

/**Classe para expor endpoint rest da funcionalidade Papeis de Papel..
* @author Brazona Tech
* @version 1.0.0
* @since release 1.0.0
*/


@Tag(name = "papeis", description = "Serviço que disponibiliza funcionalidade Papeis de Papéis", 
externalDocs = @ExternalDocumentation(
		description = "Documentação da Exemplo Roles",
		url = "https://github.com/brazona/bzn-exemplo-services/tree/main/bzn-exemplo-services-roles"))
public interface IRolesConntroller {

/**Método para criar um papéis no sistema.
	 * @param rolesModel - Objeto que contém as informações do papéis a ser criado no sistema.
	 * @return ResponseEntity<RolesModel> - Retorna o papéis criado no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao criar o papéis.
	 */


	@Operation(
		summary = "Cria papéis no sistema",
		description = "Recurso que cria informações do papéis no sistema", 
		operationId = "criarPapel",
		tags = "papeis",
		requestBody = 
			@RequestBody(
					required = true, 
					description = "Informações do Papel", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = RolesModel.class))
			),
		method = "POST",
		responses = 
			{
				@ApiResponse(
					responseCode = "200", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = RolesModel.class)),
					description = "Papel criado com sucesso!"
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
	public ResponseEntity<RolesModel>create(RolesModel rolesModel);

	/**Método para consultar um papéis no sistema.
	 * @param id - Identificador do papéis a ser consultado.
	 * @return ResponseEntity<RolesModel> - Retorna o papéis consultado no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao consultar o papéis.
	 */
	@Operation(
			summary = "Consulta papéis pelo identificador",
			description = "Através do identificador consulta as informações do papéis cadastradas no sistema.", 
			operationId = "consultaPapelId",
			tags = "papeis",
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
								schema = @Schema(implementation = RolesModel.class)),
						description = "Papel localizado com sucesso!"
						),
					@ApiResponse(
							responseCode = "404",
							description = "Papel não localizado"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	public ResponseEntity<RolesModel>readById(Long id);
	
	/**Método para atualizar um papéis no sistema.
	 * @param id - Identificador do papéis a ser atualizado.
	 * @param rolesModel - Objeto que contém as novas informações do papéis a ser atualizado no sistema.
	 * @return ResponseEntity<RolesModel> - Retorna o papéis atualizado no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao atualizar o papéis.
	 */

	@Operation(
			summary = "Atualiza papéis pelo identificador ",
			description = "Através do identificador e das novas informações atualiza as informações do papéis cadastradas no sistema.", 
			operationId = "atualizaPapel",
			tags = "papeis",
			method = "PUT",
			requestBody = 
				@RequestBody(
						required = true, 
						description = "Informações do Papel", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = RolesModel.class))
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
								schema = @Schema(implementation = RolesModel.class)),
						description = "Papel atualiza com sucesso!"
						),
					@ApiResponse(
							responseCode = "400",
							description = "Formato inválido"
					),
					@ApiResponse(
							responseCode = "404",
							description = "Papel não localizado"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	
	public ResponseEntity<RolesModel>update(Long id, RolesModel rolesModel);
	
	/**Método para deletar um papéis no sistema.
	 * @param id - Identificador do papéis a ser deletado.
	 * @return ResponseEntity<Void> - Retorna vazio caso o papéis seja deletado com sucesso.
	 * @throws Exception - Lança exceção caso ocorra erro ao deletar o papéis.
	 */
	@Operation(
			summary = "Deleta papéis pelo identificador",
			description = "Através do identificador deleta as informações do papéis cadastradas no sistema.", 
			operationId = "deletaPapelId",
			tags = "papeis",
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
						description = "Papel deletado com sucesso!"
						),
					@ApiResponse(
							responseCode = "404",
							description = "Papel não localizado"
					),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	

	public ResponseEntity<Void>delete(Long id);
	
	/**Método para consultar todos os papéis no sistema.
	 * @return ResponseEntity<List<RolesModel>> - Retorna a lista de papéis cadastrados no sistema.
	 * @throws Exception - Lança exceção caso ocorra erro ao consultar os papéis.
	 */
	@Operation(
			summary = "Consulta todos os papéis",
			description = "Consulta todos os papéis cadastradas no sistema.", 
			operationId = "listaUsuario",
			tags = "papeis",
			method = "GET",
			responses = 
				{
					@ApiResponse(
							responseCode = "200", 
							content = @Content(
									mediaType = "application/json", 
									array = @ArraySchema(schema = @Schema(implementation = RolesModel.class))),
							description = "Papéis consultados com sucesso!"
							),
					@ApiResponse(
							responseCode = "500",
							description = "Erro interno do sistema"
					)
				}	 
	)
	
	public ResponseEntity<List<RolesModel>>readAll();
	
	
}

