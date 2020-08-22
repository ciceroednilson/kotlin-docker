CREATE DATABASE db_vendas;

CREATE TABLE tb_cliente(

	id_cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ds_nome VARCHAR(50) NOT NULL,
    dt_nascimento DATE NOT  NULL,
    fl_sexo CHAR(1) NOT NULL
);
