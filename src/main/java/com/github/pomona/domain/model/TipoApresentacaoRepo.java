package com.github.pomona.domain.model;

import com.github.common.domain.model.GenericoRepo;

public interface TipoApresentacaoRepo extends GenericoRepo<TipoApresentacao, TipoApresentacaoId> {
	public TipoApresentacao tipoApresentacaoPeloNome(String nome);
}
