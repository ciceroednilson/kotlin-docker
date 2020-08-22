package br.com.ciceroednilson.repository

import br.com.ciceroednilson.entity.ClienteEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : CrudRepository<ClienteEntity, Int> {
	
	fun save(cliente:ClienteEntity)
	
	override fun delete(cliente:ClienteEntity)
	
	override fun findAll() : List<ClienteEntity>
	
	override fun findById(codigo:Int) : java.util.Optional<ClienteEntity>
}