package com.api.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.produto.model.Produto;
import com.api.produto.response.PageResponse;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public PageResponse findAll(Pageable pageable) {
		return new PageResponse(repository.findAll(pageable));
	}
	
	public Produto save(Produto produto) {
		return repository.save(produto);
	}

}
