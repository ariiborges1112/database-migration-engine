package model;

import java.math.BigDecimal;

public class Produto{
    private Integer id;
    private String nome;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private Integer quantidadeAtual;
    private Integer estoqueMinimo;
    private Categoria categoria;

    public Produto(String nome, BigDecimal precoCusto, BigDecimal precoVenda,
                   Integer estoqueMinimo, Categoria categoria){
        this.setNome(nome);
        this.setPrecoCusto(precoCusto);
        this.setPrecoVenda(precoVenda);
        this.setEstoqueMinimo(estoqueMinimo);
        this.setCategoria(categoria);
        this.setQuantidadeAtual(0);
    }

    public Produto(Integer id, String nome, BigDecimal precoCusto, BigDecimal precoVenda,
                   Integer quantidadeAtual, Integer estoqueMinimo, Categoria categoria){
        this(nome, precoCusto, precoVenda, estoqueMinimo, categoria);
        this.setId(id);
        this.setQuantidadeAtual(quantidadeAtual);
    }

    private void validarId(Integer id){
        if(id < 1) throw new IllegalArgumentException("O ID não pode ser menor que 1!");
    }

    private void validarNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser vazio!");
        }
        if(!nome.matches("^[A-Za-zÀ-ÿ0-9\\s\\-\\.\\,%]+$")){
            throw new IllegalArgumentException("Não é permitido caracteres especiais!");
        }
        if(nome.length() > 40){
            throw new IllegalArgumentException("O nome não pode ter mais que 40 caracteres!");
        }
    }

    private void validarPrecoCusto(BigDecimal precoCusto){
        if(precoCusto == null){
            throw new IllegalArgumentException("O valor de custo não pode ser nulo!");
        }
        if(precoCusto.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("O valor de custo não pode ser menor ou igual a 0!");
        }
    }

    private void validarPrecoVenda(BigDecimal precoVenda){
        if(precoVenda == null){
            throw new IllegalArgumentException("O valor de venda não pode ser nulo!");
        }
        if(precoVenda.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("O valor de venda não pode ser menor que 0!");
        }
    }

    private void validarQuantidadeAtual(Integer quantidadeAtual){
        if(quantidadeAtual == null){
            throw new IllegalArgumentException("A quantidade atual não pode ser nula!");
        }
        if(quantidadeAtual < 0){
            throw new IllegalArgumentException("A quantidade atual não pode ser menor que 0!");
        }
    }

    private void validarEstoqueMinimo(Integer estoqueMinimo){
        if(estoqueMinimo == null){
            throw new IllegalArgumentException("O estoque minimo não pode ser nulo!");
        }
        if(estoqueMinimo < 0){
            throw new IllegalArgumentException("O estoque minimo não pode ser menor que 0!");
        }
    }

    private void validarCategoria(Categoria categoria){
        if(categoria == null){
            throw new IllegalArgumentException("A categoria não pode ser nula!");
        }
        if(categoria.getId() == null || categoria.getId() < 1){
            throw new IllegalArgumentException("O ID deve existir e não pode ser menor ou igual a 0!");
        }
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        validarId(id);
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        validarNome(nome);
        this.nome = nome;
    }

    public BigDecimal getPrecoCusto(){
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto){
        validarPrecoCusto(precoCusto);
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda(){
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda){
        validarPrecoVenda(precoVenda);
        this.precoVenda = precoVenda;
    }

    public Integer getQuantidadeAtual(){
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(Integer quantidadeAtual){
        validarQuantidadeAtual(quantidadeAtual);
        this.quantidadeAtual = quantidadeAtual;
    }

    public Integer getEstoqueMinimo(){
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Integer estoqueMinimo){
        validarEstoqueMinimo(estoqueMinimo);
        this.estoqueMinimo = estoqueMinimo;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public void setCategoria(Categoria categoria){
        validarCategoria(categoria);
        this.categoria = categoria;
    }
}