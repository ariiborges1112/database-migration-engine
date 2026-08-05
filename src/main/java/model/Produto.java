package model;

import java.math.BigDecimal;

public class Produto{
    private Integer id;
    private String nome;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private Integer quantidadeAtual;
    private Integer estoqueMinimo;
    private Categoria categoriaId;

    public Produto(String nome, BigDecimal precoCusto, BigDecimal precoVenda,
                   Integer estoqueMinimo, Categoria categoriaId){
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidadeAtual = 0;
        this.estoqueMinimo = estoqueMinimo;
        this.categoriaId = categoriaId;
    }

    public Produto(Integer id, String nome, BigDecimal precoCusto, BigDecimal precoVenda,
                   Integer estoqueMinimo, Categoria categoriaId){
        this(nome, precoCusto, precoVenda, estoqueMinimo, categoriaId);
        this.id = id;
        this.quantidadeAtual = 0;
    }

    /*
    CRIAR METODOS DE REGRA DE NEGOCIO
    METODOS DE VALIDAÇÃO
     */

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

    public Categoria getCategoriaId(){
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId){
        validarCategoriaId(categoriaId);
        this.categoriaId = categoriaId;
    }
}