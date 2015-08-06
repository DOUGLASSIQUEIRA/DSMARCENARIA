

create table tipo_telefone(
id_tipo_telefone integer primary key,
ds_fone varchar(50)
)

create table telefone(
id_pessoa integer references pessoa(id_pessoa),
sequencia integer not null,
id_tipo_telefone integer references tipo_telefone(id_tipo_telefone),
nr_telefone integer,
primary key(id_pessoa,sequencia)
)

create table passoa_fisica(
id_pessoa integer references pessoa(id_pessoa),
rg integer,
cpf integer,
sexo char(1),
dt_nascimento date,
primary key(id_pessoa)
)

create table pessoa_juridica(
id_pessoa integer references pessoa(id_pessoa),
cnpj char(20),
inscricao_estadual varchar(50),
inscricao_municipal varchar(50),
atividade varchar(100),
data_fundacao date,
razao_social varchar(300),
primary key(id_pessoa)
)

create table funcionario(
id_pessoa integer references passoa_fisica(id_pessoa),
data_adimissao date,
data_demissao date,
primary key(id_pessoa)
)

create table fornecedor(
id_pessoa integer references pessoa_juridica(id_pessoa),
dt_cadastro date,
primary key(id_pessoa)
)

create table perfil_usuario(
id_perfil integer primary key,
ds_perfil varchar(60)
)

create table usuarios(
id_pessoa integer references funcionario(id_pessoa),
id_perfil integer references perfil_usuario(id_perfil),
nm_usuario varchar(30),
senha varchar(8),
primary key(id_pessoa)
)

create table telas(
id_telas integer primary key,
ds_telas varchar(30),
vlt_tela integer
)

create table usuarios_telas(
id_pessoa integer references usuarios(id_pessoa),
id_telas integer references telas(id_telas),
primary key(id_pessoa,id_telas)
)

create table telas_perfil_usuarios(
id_perfil integer references perfil_usuario(id_perfil),
id_telas integer references telas(id_telas),
primary key(id_perfil,id_telas)
)