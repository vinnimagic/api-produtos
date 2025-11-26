package com.exemplo.demo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    // Rota 3: Buscar por ID (GET /produtos/1)
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Rota 4: Filtro por nome (GET /produtos/busca?nome=Gamer)
    @GetMapping("/busca")
    public List<Produto> filtrar(@RequestParam String nome) {
        return service.buscarPorNome(nome);
    }

    @PostMapping
    public ResponseEntity<Produto> adicionar(@RequestBody @Valid Produto produto) {
        Produto novoProduto = service.salvar(produto);
        return ResponseEntity.status(201).body(novoProduto);
    }

    // Rota 5: Atualizar (PUT /produtos/1)
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(service.atualizar(id, produto));
    }

    // Rota 6: Deletar (DELETE /produtos/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}