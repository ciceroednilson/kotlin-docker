package br.com.ciceroednilson.service

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import br.com.ciceroednilson.repository.ClienteRepository
import br.com.ciceroednilson.model.ClienteModel
import br.com.ciceroednilson.entity.ClienteEntity

@Service
class ClienteService {
	
	@Autowired
    private lateinit var clienteRepository:ClienteRepository
	
	fun criar(cliente:ClienteModel){
		
		var clienteEntity = ClienteEntity(
			cliente.nome,
			 java.sql.Date(cliente.dataNascimento.getTime()),
			cliente.sexo
		)

		/*APENAS NA ATUALIZACAO VAMOS PASSAR O ID*/		
		if(cliente.id != null)
			clienteEntity.setId(cliente.id)
		
		this.clienteRepository.save(clienteEntity);		
	}
	
	fun atualizar(cliente:ClienteModel){
		this.criar(cliente)
	}
	
	fun excluir(id:Int){
		
		var clienteEntity = this.clienteRepository.findById(id)
		
		this.clienteRepository.delete(clienteEntity.get())
	}

	fun consultarTodos(): List<ClienteModel>{
	
		val clientesModel:MutableList<ClienteModel> = mutableListOf() 
		
		var clientesEntity = this.clienteRepository.findAll();

		clientesEntity.forEach {cli ->
		
			clientesModel.add(ClienteModel(cli.getId(), cli.nome, cli.dataNascimento,cli.sexo));
		}

		
		return clientesModel;
	}
	
	fun consultarPorId(id:Int): ClienteModel{
		
		var clienteModel =  ClienteModel()
		
		var clienteEntity = this.clienteRepository.findById(id)
		
		clienteModel.id =  clienteEntity.get().getId()
		clienteModel.dataNascimento = clienteEntity.get().dataNascimento
		clienteModel.sexo = clienteEntity.get().sexo
		clienteModel.nome = clienteEntity.get().nome
		
		return clienteModel
	}
	
	
	
	
}