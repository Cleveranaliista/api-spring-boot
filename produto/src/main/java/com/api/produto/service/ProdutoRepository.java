package com.api.produto.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.api.produto.model.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>{

}
