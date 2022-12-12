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
	ano int,
	tipo integer,
	altura float,
	largura float,
	profundidade float,
	foreign key (tipo) references tipos (identificador)
);

SELECT codigo, itens.nome, descricao, ano, tipo, altura, largura, profundidade, identificador, tipos.nome FROM itens JOIN tipos ON itens.tipo = tipos.identificador;

SELECT codigo, nome, descricao, ano, tipo, altura, largura, profundidade FROM itens WHERE altura > (SELECT AVG(altura) FROM itens);