package com.api.pedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.pedido.model.Pedido;
import com.api.pedido.response.PageResponse;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public PageResponse findAll(Pageable pageable) {
		return new PageResponse(repository.findAll(pageable));
	}
	
	public Pedido save(Pedido produto) {
		return repository.save(produto);
	}

}
