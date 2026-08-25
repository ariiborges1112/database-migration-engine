package dao;

import model.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemVendaDAO{
    private Connection conexao;

    public ItemVendaDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void insertItemVenda(ItemVenda itemVenda){
        String sql = "INSERT INTO item_venda (venda_id, produto_id, " +
                "quantidade_vendida, preco_unitario) VALUES (?, ?, ?, ?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, itemVenda.getVenda().getId());
            stmt.setInt(2, itemVenda.getProduto().getId());
            stmt.setInt(3, itemVenda.getQuantidadeVendida());
            stmt.setBigDecimal(4, itemVenda.getPrecoUnitario());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao inserir itens vendidos", e);
        }
    }
}