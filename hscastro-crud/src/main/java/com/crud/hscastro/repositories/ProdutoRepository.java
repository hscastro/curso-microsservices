package com.crud.hscastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.hscastro.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
 
}
