package com.hscastro.hscastro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hscastro.hscastro.data.vo.ProdutoVO;
import com.hscastro.hscastro.entities.Produto;
import com.hscastro.hscastro.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public ProdutoVO create(ProdutoVO produtoVO) {
		return null;
	}
	
	public Page<ProdutoVO> findAll(Pageable pageable){
		var page = produtoRepository.findAll(pageable);
		return page.map(this::converterToProdutoVO);
	}
	
	private ProdutoVO converterToProdutoVO(Produto produto) {
		return ProdutoVO.create(produto);
	}

}
