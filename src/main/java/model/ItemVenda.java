package model;

import java.math.BigDecimal;

public class ItemVenda{
    private Venda venda;
    private Produto produto;
    private Integer quantidadeVendida;
    private BigDecimal precoUnitario;

    public ItemVenda(Venda venda, Produto produto, Integer quantidadeVendida, BigDecimal precoUnitario){
        this.setVenda(venda);
        this.setProduto(produto);
        this.setQuantidadeVendida(quantidadeVendida);
        this.setPrecoUnitario(precoUnitario);
    }

    private void validarVenda(Venda venda){
        if(venda == null){
            throw new IllegalArgumentException("A venda não pode ser nula!");
        }
        if(venda.getId() == null || venda.getId() < 1){
            throw new IllegalArgumentException("O ID deve existir e não pode ser menor que 1!");
        }
    }

    private void validarProduto(Produto produto){
        if(produto == null){
            throw new IllegalArgumentException("O produto não pode ser nulo!");
        }
        if(produto.getId() == null || produto.getId() < 1){
            throw new IllegalArgumentException("O ID deve existir e não pode ser menor que 1!");
        }
    }

    private void validarQuantidadeVendida(Integer quantidadeVendida){
        if(quantidadeVendida == null){
            throw new IllegalArgumentException("A quantidade vendida não pode ser nula!");
        }
        if(quantidadeVendida < 1){
            throw new IllegalArgumentException("A quantidade vendida de um item não pode ser menor que 1!");
        }
    }

    private void validarPrecoUnitario(BigDecimal precoUnitario){
        if(precoUnitario == null){
            throw new IllegalArgumentException("O preço unitario não pode ser nulo!");
        }
        if(precoUnitario.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("O preço unitario não pode ser menor que 0!");
        }
    }

    public Venda getVenda(){
        return venda;
    }

    public void setVenda(Venda venda){
        validarVenda(venda);
        this.venda = venda;
    }

    public Produto getProduto(){
        return produto;
    }

    public void setProduto(Produto produto){
        validarProduto(produto);
        this.produto = produto;
    }

    public Integer getQuantidadeVendida(){
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(Integer quantidadeVendida){
        validarQuantidadeVendida(quantidadeVendida);
        this.quantidadeVendida = quantidadeVendida;
    }

    public BigDecimal getPrecoUnitario(){
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario){
        validarPrecoUnitario(precoUnitario);
        this.precoUnitario = precoUnitario;
    }
}