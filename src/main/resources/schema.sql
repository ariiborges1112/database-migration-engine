create table cliente(
	id integer primary key autoincrement,
	nome text not null,
	cpf text not null unique,
	telefone text not null
)

create table fornecedor(
	id integer primary key autoincrement,
	nome text not null,
	cnpj text not null unique,
	telefone text not null
)

create table categoria(
	id integer primary key autoincrement,
	nome text not null
)

create table produto(
	id integer primary key autoincrement,
	nome text not null,
	preco_custo real not null,
	preco_venda real not null,
	quantidade_atual integer default 0,
	estoque_minimo integer not null,
	
	categoria_id integer,
	foreign key(categoria_id) references categorias(id)
);

create table venda(
	id integer primary key autoincrement,
	data_venda text default current_timestamp,
	forma_pagamento text not null,
	valor_total real not null,
	cliente_id integer not null,
	
	foreign key(cliente_id) references clientes(id)
);

create table item_venda(
	venda_id integer,
	produto_id integer,
	quantidade_vendida integer not null,
	preco_unitario real not null,
	
	primary key(venda_id, produto_id),
	foreign key(venda_id) references venda(id),
	foreign key(produto_id) references produtos(id)
);

create view produtos_precisam_ser_comprados as
select
	c.nome as nome_categoria,
	p.nome as nome_produto,
	p.quantidade_atual,
	p.estoque_minimo
from
	produtos as p
join categorias as c
	on c.id = p.categoria_id
where
	p.quantidade_atual <= p.estoque_minimo;

create view view_cupom_fiscal as
select
	c.nome as nome_cliente,
	p.nome as nome_produto,
	v.id as numero_venda,
	v.data_venda,
	iv.quantidade_vendida,
	iv.preco_unitario,
	(iv.quantidade_vendida * iv.preco_unitario) as subtotal_do_item
from
	venda as v
join clientes as c
	on c.id = v.cliente_id
join item_venda as iv
	on iv.venda_id = v.id
join produtos as p
	on iv.produto_id = p.id;