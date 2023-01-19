/**
	Mini projeto - Carômetro
	@author - Karen
 */
 
create database carometrokaren;

show databases;
use carometro;
 
-- blob, mediumblob, longblob (tipos de dados que aceitam
-- qualquer tipo de arquivos no formato binário)
create table alunos (
	id int primary key auto_increment,
    nome varchar(50) not null,
    foto longblob
);

describe alunos;