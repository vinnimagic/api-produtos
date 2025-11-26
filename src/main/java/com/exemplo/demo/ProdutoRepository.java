package com.exemplo.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // O Spring cria o SQL automaticamente: "SELECT * FROM produto WHERE UPPER(nome) LIKE UPPER(%nome%)"
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}