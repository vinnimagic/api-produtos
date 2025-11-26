package com.exemplo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Novo: Buscar por ID
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Novo: Filtrar por nome
    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Produto salvar(Produto produto) {
        if (produto.getCategoria() != null && produto.getCategoria().getId() != null) {
            categoriaRepository.findById(produto.getCategoria().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
        }
        return produtoRepository.save(produto);
    }

    // Novo: Atualizar
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado para atualização!");
        }
        produtoAtualizado.setId(id); // Garante que o ID é o mesmo
        return salvar(produtoAtualizado); // Reaproveita a validação do salvar
    }

    // Novo: Deletar
    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado para exclusão!");
        }
        produtoRepository.deleteById(id);
    }
}