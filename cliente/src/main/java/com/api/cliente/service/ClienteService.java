package com.api.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.cliente.model.Cliente;
import com.api.cliente.response.PageResponse;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public PageResponse findAll(Pageable pageable) {
		return new PageResponse(repository.findAll(pageable));
	}
	
	public Cliente save(Cliente produto) {
		return repository.save(produto);
	}

}
