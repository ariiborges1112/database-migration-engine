package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Venda{
    private Integer id;
    private LocalDateTime dataVenda;
    private String formaPagamento;
    private BigDecimal valorTotal;
    private Cliente cliente;

    public Venda(String formaPagamento, BigDecimal valorTotal, Cliente cliente){
        this.setDataVenda(LocalDateTime.now());
        this.setFormaPagamento(formaPagamento);
        this.setValorTotal(valorTotal);
        this.setCliente(cliente);
    }

    public Venda(Integer id, LocalDateTime dataVenda, String formaPagamento,
                 BigDecimal valorTotal, Cliente cliente){
        this(formaPagamento, valorTotal, cliente);
        this.setId(id);
        this.setDataVenda(dataVenda);
    }

    public Venda(){
    }

    private void validarId(Integer id){
        if(id < 1) throw new IllegalArgumentException("O ID não pode ser menor que 1!");
    }

    private void validarDataVenda(LocalDateTime dataVenda){
        if(dataVenda == null){
            throw new IllegalArgumentException("A data de venda não pode ser nula!");
        }
        if(dataVenda.isAfter(LocalDateTime.now())){
            throw new IllegalArgumentException("A data de venda não pode ser uma data no futuro!");
        }
    }

    private void validarFormaPagamento(String formaPagamento){
        if(formaPagamento == null || formaPagamento.trim().isEmpty()){
            throw new IllegalArgumentException("A forma de pagamento não pode ser vazio!");
        }
        if(formaPagamento.length() > 20){
            throw new IllegalArgumentException("A forma de pagamento não pode ter mais que 20 caracteres");
        }
    }

    private void validarValorTotal(BigDecimal valorTotal){
        if(valorTotal == null){
            throw new IllegalArgumentException("O valor total não pode ser nulo!");
        }
        if(valorTotal.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("O valor total não pode ser menor que 0!");
        }
    }

    private void validarCliente(Cliente cliente){
        if(cliente == null){
            throw new IllegalArgumentException("O cliente não pode ser nulo!");
        }
        if(cliente.getId() == null || cliente.getId() < 1){
            throw new IllegalArgumentException("O ID deve existir e não pode ser menor que 1!");
        }
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        validarId(id);
        this.id = id;
    }

    public LocalDateTime getDataVenda(){
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda){
        validarDataVenda(dataVenda);
        this.dataVenda = dataVenda;
    }

    public String getFormaPagamento(){
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento){
        validarFormaPagamento(formaPagamento);
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getValorTotal(){
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal){
        validarValorTotal(valorTotal);
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        validarCliente(cliente);
        this.cliente = cliente;
    }
}