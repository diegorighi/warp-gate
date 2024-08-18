-- Criação do esquema
CREATE SCHEMA "warp-api";

-- Criação da sequence para o ID da tabela documentos
CREATE SEQUENCE documentos_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

-- Criação da sequence para o ID da tabela cliente
CREATE SEQUENCE cliente_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

-- Criação da sequence para o ID da tabela usuario
CREATE SEQUENCE usuario_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

-- Criação da tabela endereco
CREATE TABLE endereco (
    id BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    logradouro VARCHAR(255) NOT NULL,
    numero_logradouro BIGINT,
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    cep VARCHAR(255) NOT NULL,
    estado VARCHAR(255) NOT NULL
);

-- Criação da tabela contato
CREATE TABLE contato (
    id BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    email VARCHAR(255) NOT NULL,
    numero_telefone VARCHAR(255) NOT NULL
);

-- Criação da tabela cliente
CREATE TABLE cliente (
    id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('cliente_seq'),
    primeiro_nome VARCHAR(255) NOT NULL,
    nome_meio VARCHAR(255),
    sobrenome VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP,
    data_atualizacao TIMESTAMP,
    tipo_cliente VARCHAR(255) NOT NULL,
    endereco_id BIGINT,
    contato_id BIGINT,
    CONSTRAINT fk_cliente_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id) ON DELETE SET NULL,
    CONSTRAINT fk_cliente_contato FOREIGN KEY (contato_id) REFERENCES contato(id) ON DELETE SET NULL
);

-- Criação da tabela documentos
CREATE TABLE documentos (
    id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('documentos_seq'),
    tipo_documento VARCHAR(255) NOT NULL,
    numero_documento VARCHAR(255) NOT NULL,
    orgao_expedidor VARCHAR(255),
    data_expedicao TIMESTAMP,
    data_validade TIMESTAMP,
    cliente_id BIGINT,
    CONSTRAINT fk_documentos_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE SET NULL
);

-- Criação da tabela usuario
CREATE TABLE usuario (
    id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('usuario_seq'),
    login VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo_premium VARCHAR(255) NOT NULL,
    cliente_id BIGINT,
    CONSTRAINT fk_usuario_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE SET NULL
);
