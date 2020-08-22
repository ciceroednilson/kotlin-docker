package br.com.ciceroednilson.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import br.com.ciceroednilson.service.ClienteService
import org.springframework.web.bind.annotation.RequestBody
import br.com.ciceroednilson.model.ClienteModel
import org.springframework.http.ResponseEntity
import br.com.ciceroednilson.model.ResultadoModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.beans.factory.annotation.Autowired

@RestController
@RequestMapping("/cliente")
class ClienteController() {
	
	@Autowired
	private lateinit var clienteService:ClienteService
	
	@ResponseBody
	@PostMapping
	public fun cadastrar(@RequestBody cliente:ClienteModel): ResponseEntity<ResultadoModel> {
		
		this.clienteService.criar(cliente)
		
		return  ResponseEntity<ResultadoModel>(ResultadoModel("Cliente cadastrado com sucesso!"), HttpStatus.OK)
	}
	
	@ResponseBody
	@PutMapping
	public fun atualizar(@RequestBody cliente:ClienteModel): ResponseEntity<ResultadoModel> {
		
		this.clienteService.atualizar(cliente)
		
		return  ResponseEntity<ResultadoModel>(ResultadoModel("Cliente alterado com sucesso!"), HttpStatus.OK)
	}
	
	@ResponseBody
	@DeleteMapping("{id}")
	public fun delete(@PathVariable id:Int): ResponseEntity<ResultadoModel> {
		
		this.clienteService.excluir(id);
		
		return  ResponseEntity<ResultadoModel>(ResultadoModel("Cliente excluido com sucesso!"), HttpStatus.OK)
	}
	
	@ResponseBody
	@GetMapping("{id}")
	public fun buscar(@PathVariable id:Int): ResponseEntity<ClienteModel> {
		
		var clienteModel = this.clienteService.consultarPorId(id)
		
		return  ResponseEntity<ClienteModel>(clienteModel, HttpStatus.OK)
	}	
	
	@ResponseBody
	@GetMapping
	public fun buscarTodos(): ResponseEntity<List<ClienteModel>> {
		
		var clientesModel = this.clienteService.consultarTodos();
		
		return  ResponseEntity<List<ClienteModel>>(clientesModel, HttpStatus.OK)
	}	
	
	
	
	
}