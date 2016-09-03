CREATE TABLE locadora.tituloAtor
(
idAtor  int NOT NULL,
idTitulo int NOT NULL,
PRIMARY KEY(idAtor)

); 

CREATE TABLE locadora.categoria
(
id  int NOT NULL,
nome  varchar(20)  NULL,
PRIMARY KEY(id)

); 

CREATE TABLE locadora.diretor
(
id  int NOT NULL,
nome varchar(20) NULL,
PRIMARY KEY(id)

); 

CREATE TABLE locadora.tituloDiretor
(
id  int NOT NULL,
idDiretor INT NOT NULL,

PRIMARY KEY(id)

); 


CREATE TABLE locadora.classe
(
id  int NOT NULL,
nome varchar(20) NULL,
preco decimal(11,2) null,
prazo int null,
PRIMARY KEY(id)

); 




CREATE TABLE locadora.pais
(
id  int NOT NULL,
nome varchar(20) null,
sigla varchar(3) null,
PRIMARY KEY(id)

); 

CREATE TABLE locadora.estado
(
id  int NOT NULL,
nome varchar(20) null,
sigla varchar(2) null,
PRIMARY KEY(id)

); 

CREATE TABLE locadora.cidade
(
id  int NOT NULL,
idEstado  int NOT NULL,
nome varchar(20) null,

PRIMARY KEY(id)

); 

CREATE TABLE locadora.bairro
(
id  int NOT NULL,
idCidade  int NOT NULL,
nome varchar(20) null,

PRIMARY KEY(id)

); 

