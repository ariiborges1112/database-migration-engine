package dao;

import model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}