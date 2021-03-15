package com.crud.hscastro.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crud.hscastro.data.vo.ProdutoVO;
import com.crud.hscastro.entities.Produto;
import com.crud.hscastro.exception.ResourceNotFoundException;
import com.crud.hscastro.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public ProdutoVO create(ProdutoVO produtoVO) {
		ProdutoVO proVORetorno = ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
		return proVORetorno;
	}
	
	public Page<ProdutoVO> findAll(Pageable pageable){
		var page = produtoRepository.findAll(pageable);
		return page.map(this::converterToProdutoVO);
	}
	
	private ProdutoVO converterToProdutoVO(Produto produto) {
		return ProdutoVO.create(produto);
	}
	
	public ProdutoVO findById(Long id) {
		var entity = produtoRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
		
		return ProdutoVO.create(entity);
	}	

	@SuppressWarnings("static-access")
	public ProdutoVO update(ProdutoVO produtoVO) {
		final Optional<Produto> optionalProduto = produtoRepository.findById(produtoVO.getId());
		
		if(!optionalProduto.isPresent()) {
			new ResourceNotFoundException("No records found for this ID");
		}
				
		return produtoVO.create(produtoRepository.save(Produto.create(produtoVO)));
	}
	
	public void delete(Long id){
		var entity = produtoRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
		produtoRepository.delete(entity);
	}
	
}
