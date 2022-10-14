CREATE TABLE VEM_SER.USUARIO (
  id_usuario NUMBER NOT NULL,
  nome VARCHAR2(255) NOT NULL,
  idade NUMBER NOT NULL,
  email VARCHAR2(255) NOT NULL,
  senha VARCHAR2(255) NOT NULL,
  tipo_usuario VARCHAR2(20) NOT NULL,
  PRIMARY KEY (id_usuario)
);

CREATE SEQUENCE VEM_SER.SEQ_USUARIO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;



CREATE TABLE VEM_SER.ITEM_ENTRETENIMENTO (
  id_item_entretenimento NUMBER NOT NULL,
  nome VARCHAR2(255) NOT NULL,
  tipo VARCHAR2(255) NOT NULL,
  genero VARCHAR2(255) NOT NULL,
  sinopse VARCHAR2(1000),
  ano_lancamento VARCHAR2(10) NOT NULL,
  classificacao NUMBER NOT NULL,
  plataforma VARCHAR2(255) NOT NULL,
  duracao VARCHAR2(255) ,
  temporadas NUMBER,
  episodios NUMBER,
  PRIMARY KEY (id_item_entretenimento)
);

CREATE SEQUENCE VEM_SER.SEQ_ITEM_ENTRETENIMENTO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE TABLE VEM_SER.AVALIACAO (
  id_usuario NUMBER NOT NULL,
  id_item_entretenimento NUMBER NOT NULL,
  nota NUMBER NOT NULL,
  comentario VARCHAR2(1000) ,
  CONSTRAINT FK_id_usario FOREIGN KEY ( id_usuario ) REFERENCES VEM_SER.USUARIO( id_usuario ),
  CONSTRAINT FK_id_item_entretenimento FOREIGN KEY ( id_item_entretenimento ) REFERENCES VEM_SER.ITEM_ENTRETENIMENTO( id_item_entretenimento ),
  PRIMARY KEY (id_usuario, id_item_entretenimento)
);



CREATE TABLE VEM_SER.ASSISTIDOS (
  id_usuario NUMBER NOT NULL,
  id_item_entretenimento NUMBER NOT NULL,
  CONSTRAINT FK_id_usario_assistidos FOREIGN KEY ( id_usuario ) REFERENCES VEM_SER.USUARIO( id_usuario ),
  CONSTRAINT FK_id_item_entretenimento_as FOREIGN KEY ( id_item_entretenimento ) REFERENCES VEM_SER.ITEM_ENTRETENIMENTO( id_item_entretenimento ),
  PRIMARY KEY (id_usuario, id_item_entretenimento)
);

-filmes

INSERT INTO VEM_SER.ITEM_ENTRETENIMENTO(id_item_entretenimento , nome, tipo, genero, sinopse, ano_lancamento, classificacao, plataforma, duracao, temporadas, episodios)
VALUES (VEM_SER.SEQ_ITEM_ENTRETENIMENTO.nextval, 'Duro de Matar', 'filme', 'acao', 'foda', '1988', 18, 'Netflix', '120', NULL, NULL);

INSERT INTO VEM_SER.ITEM_ENTRETENIMENTO(id_item_entretenimento , nome, tipo, genero, sinopse, ano_lancamento, classificacao, plataforma, duracao, temporadas, episodios)
VALUES (VEM_SER.SEQ_ITEM_ENTRETENIMENTO.nextval, 'Titanic', 'filme', 'Romance', 'triste', '1997', 12, 'Filmes online gratis HD', '155', NULL, NULL);

INSERT INTO VEM_SER.ITEM_ENTRETENIMENTO(id_item_entretenimento , nome, tipo, genero, sinopse, ano_lancamento, classificacao, plataforma, duracao, temporadas, episodios)
VALUES (VEM_SER.SEQ_ITEM_ENTRETENIMENTO.nextval, 'Senhor dos aneis', 'filme', 'Fantasia', 'muito foda', '2001', 12, 'Amazon prime', '220', NULL, NULL);

--series

INSERT INTO VEM_SER.ITEM_ENTRETENIMENTO(id_item_entretenimento , nome, tipo, genero, sinopse, ano_lancamento, classificacao, plataforma, duracao, temporadas, episodios)
VALUES (VEM_SER.SEQ_ITEM_ENTRETENIMENTO.nextval, 'Game of Thrones', 'serie', 'Drama', 'Um monte gente brigando pra ver quem vai ser Rei', '2011', 16, 'HBO MAX', NULL , 7, 73);

INSERT INTO VEM_SER.ITEM_ENTRETENIMENTO(id_item_entretenimento , nome, tipo, genero, sinopse, ano_lancamento, classificacao, plataforma, duracao, temporadas, episodios)
VALUES (VEM_SER.SEQ_ITEM_ENTRETENIMENTO.nextval, 'The Office', 'serie', 'Comedia', 'Mostra a rotina de um escritorio', '2005', 14, 'HBO MAX', NULL , 9, 120);

-- admins

INSERT INTO VEM_SER.USUARIO(id_usuario, nome, idade, email, senha, tipo_usuario)
VALUES (VEM_SER.SEQ_USUARIO.nextval, 'gustavo', 21, 'gustavo@gmail.com', '1234', 'administrador');

INSERT INTO VEM_SER.USUARIO(id_usuario, nome, idade, email, senha, tipo_usuario)
VALUES (VEM_SER.SEQ_USUARIO.nextval, 'aliso', 21, 'aliso@gmail.com', '1234', 'administrador');


--clientes

INSERT INTO VEM_SER.USUARIO(id_usuario, nome, idade, email, senha, tipo_usuario)
VALUES (VEM_SER.SEQ_USUARIO.nextval, 'seu ze', 60, 'ze@gmail.com', '1234', 'cliente');

INSERT INTO VEM_SER.ASSISTIDOS(id_usuario,id_item_entretenimento)
VALUES (1,1);

INSERT INTO VEM_SER.AVALIACAO (id_usuario,id_item_entretenimento,nota,comentario)
VALUES (2,2,10,'Bom');

SELECT * FROM VEM_SER.ITEM_ENTRETENIMENTO;

SELECT * FROM VEM_SER.USUARIO;

SELECT * FROM VEM_SER.AVALIACAO;

SELECT * FROM VEM_SER.ASSISTIDOS;

