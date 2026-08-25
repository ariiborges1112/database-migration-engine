package dao;

import model.ItemVenda;
import model.Produto;
import model.Venda;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<ItemVenda> todosItensVendidos(){
        String sql = "SELECT * FROM item_venda";
        List<ItemVenda> itensVendidos = new ArrayList<>();

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Integer idVenda = rs.getInt("venda_id");
                Venda itemDaVenda = new Venda();
                itemDaVenda.setId(idVenda);

                Integer idProduto = rs.getInt("produto_id");
                Produto produtoDaVenda = new Produto();
                produtoDaVenda.setId(idProduto);

                Integer quantidadeVenda = rs.getInt("quantidade_vendida");
                BigDecimal precoUnitario = rs.getBigDecimal("preco_unitario");

                ItemVenda itemVenda = new ItemVenda(itemDaVenda, produtoDaVenda,
                        quantidadeVenda, precoUnitario);

                itensVendidos.add(itemVenda);
            }

            return itensVendidos;
        }catch(SQLException e){
            throw new RuntimeException("Erro ao buscar items vendidos", e);
        }
    }

    public void updateItemVenda(ItemVenda itemVenda){
        String sql = "UPDATE item_venda SET venda_id = ?, produto_id = ? " +
                "WHERE quantidade_vendida = ? AND preco_unitario = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, itemVenda.getVenda().getId());
            stmt.setInt(2, itemVenda.getProduto().getId());
            stmt.setInt(3, itemVenda.getQuantidadeVendida());
            stmt.setBigDecimal(4, itemVenda.getPrecoUnitario());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar item vendido", e);
        }
    }
}