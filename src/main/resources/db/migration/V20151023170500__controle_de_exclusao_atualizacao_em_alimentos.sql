alter table AlimentoUnitario 
	add column dataExclusao DATETIME NULL default NULL AFTER categoriaAlimento_id;
	
alter table ApresentacaoMedidaAlimento 
	add column dataCadastro DATETIME not NULL AFTER tipoMedida_id;

alter table ApresentacaoMedidaAlimento 
	change column quantidade quantidade FLOAT NULL;
