CREATE TABLE tipos
(
	identificador integer,
	nome varchar(25),
	primary key(identificador)
);

CREATE TABLE itens
(
	codigo integer,
	nome varchar(25),
	descricao varchar(300),
	criacao date,
	materiais varchar(150),
	tipo integer,
	altura integer,
	largura integer,
	profundidade integer,
	foreign key (tipo) references tipos (identificador)
);