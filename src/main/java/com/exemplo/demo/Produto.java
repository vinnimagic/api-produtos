package com.exemplo.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*; // Importante importar isso!

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório") // Não pode ser null nem vazio
    private String nome;

    @Positive(message = "O preço deve ser maior que zero") // Garante preço positivo
    private Double preco;

    @Size(min = 10, max = 200, message = "A descrição deve ter entre 10 e 200 caracteres")
    private String descricao;

    @Min(value = 0, message = "O estoque não pode ser negativo")
    private Integer quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Construtores, Getters e Setters continuam iguais...
    // (Pode manter o código que já estava aqui para baixo)

    public Produto() {}

    public Produto(String nome, Double preco, String descricao, Integer quantidadeEstoque, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    // ... Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}