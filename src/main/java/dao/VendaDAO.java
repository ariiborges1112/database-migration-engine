package dao;

import model.Cliente;
import model.Venda;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO{
    private Connection conexao;

    public VendaDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void insertVenda(Venda venda){
        String sql = "INSERT INTO venda (forma_pagamento, valor_total, cliente_id) " +
                "VALUES (?, ?, ?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, venda.getFormaPagamento());
            stmt.setBigDecimal(2, venda.getValorTotal());
            stmt.setInt(3, venda.getCliente().getId());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao inserir venda", e);
        }
    }

    public List<Venda> todasVendas(){
        String sql = "SELECT * FROM venda";
        List<Venda> vendas = new ArrayList<>();

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt("id");
                LocalDateTime dataVenda = rs.getTimestamp("data_venda").toLocalDateTime();
                String formaPagamento = rs.getString("forma_pagamento");
                BigDecimal valorTotal = rs.getBigDecimal("valor_total");

                Integer idCliente = rs.getInt("cliente_id");
                Cliente clienteDaVenda = new Cliente();
                clienteDaVenda.setId(idCliente);

                Venda vendaConsulta = new Venda(id, dataVenda, formaPagamento,
                        valorTotal, clienteDaVenda);
                vendas.add(vendaConsulta);
            }
            return vendas;
        }catch(SQLException e){
            throw new RuntimeException("Erro ao buscar vendas", e);
        }
    }

    public void updateVenda(Venda venda){
        String sql = "UPDATE venda SET forma_pagamento = ?, valor_total = ?, " +
                "cliente_id = ? WHERE id = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, venda.getFormaPagamento());
            stmt.setBigDecimal(2, venda.getValorTotal());
            stmt.setInt(3,venda.getCliente().getId());
            stmt.setInt(4,venda.getId());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar venda", e);
        }
    }

    public void deleteVenda(Integer id){
        String sql = "DELETE FROM venda WHERE id = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao deletar venda", e);
        }
    }
}