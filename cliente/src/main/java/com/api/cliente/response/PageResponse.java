package com.api.cliente.response;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageResponse {

	private List<?> registros;
	private long totalRegistros;
	private int totalPaginas;
	private int totalRegistrosPaginaAtual;
	private boolean ultimaPagina;
	private boolean primeiraPagina;
	private int numeroPaginaAtual;

	public PageResponse (Page<?> pageResult) {
			this.registros = pageResult.getContent();
			this.totalRegistros = pageResult.getTotalElements();
			this.totalRegistrosPaginaAtual = pageResult.getNumberOfElements();
			this.totalPaginas = pageResult.getTotalPages();
			this.numeroPaginaAtual = pageResult.getNumber();
			this.primeiraPagina = pageResult.isFirst();
			this.ultimaPagina = pageResult.isLast();
		}
}
