package br.com.ciceroednilson.model

import java.util.Date

class ClienteModel{

	var id:Int? = null
	lateinit var nome:String
	lateinit var dataNascimento:Date
	lateinit var sexo:String
	
	constructor()
	
	constructor(id:Int?, nome:String, dataNascimento:Date,sexo:String){
		this.id = id
		this.nome = nome
		this.dataNascimento = dataNascimento
		this.sexo = sexo
	}
}
		
