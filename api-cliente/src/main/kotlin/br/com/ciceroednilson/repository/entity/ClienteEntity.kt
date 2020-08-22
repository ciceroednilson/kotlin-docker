package br.com.ciceroednilson.entity

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name="tb_cliente")
data class ClienteEntity(
	

	@Column(name="ds_nome")
	val nome:String,

	@Column(name="dt_nascimento")
	val dataNascimento:Date,

	@Column(name="fl_sexo")
	val sexo:String
){
	
	
	@Id
	@Column(name="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private var id:Int? = null
	
	fun getId(): Int?{
		return id;
	}
	
	fun setId(id:Int?){
		this.id = id;
	} 
}