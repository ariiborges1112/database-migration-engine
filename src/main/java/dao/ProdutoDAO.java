package dao;

import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO{
    private Connection conexao;

    public ProdutoDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void insertProduto(Produto produto){
        String sql = "INSERT INTO produto (nome, preco_custo, preco_venda, " +
                "quantidade_atual, estoque_minimo, categoria_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, produto.getNome());
            stmt.setBigDecimal(2, produto.getPrecoCusto());
            stmt.setBigDecimal(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQuantidadeAtual());
            stmt.setInt(5, produto.getEstoqueMinimo());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao inserir produto", e);
        }
    }

    public List<Produto> todosProdutos(){

    }

    public void updateProduto(Produto produto){

    }

    public void deleteProduto(Integer id){
        String sql = "DELETE FROM produto WHERE id = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao deletar produto", e);
        }
    }
}