package dao;

import model.Categoria;
import model.Produto;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            stmt.setInt(6, produto.getCategoria().getId());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao inserir produto", e);
        }
    }

    public List<Produto> todosProdutos(){
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<>();

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                BigDecimal precoCusto = rs.getBigDecimal("preco_custo");
                BigDecimal precoVenda = rs.getBigDecimal("preco_venda");
                Integer quantidadeAtual = rs.getInt("quantidade_atual");
                Integer estoqueMinimo = rs.getInt("estoque_minimo");

                Integer idCategoria = rs.getInt("categoria_id");
                Categoria categoriaDoProduto = new Categoria();
                categoriaDoProduto.setId(idCategoria);

                Produto produtoConsulta = new Produto(id, nome, precoCusto, precoVenda,
                        quantidadeAtual, estoqueMinimo, categoriaDoProduto);
                produtos.add(produtoConsulta);
            }
            return produtos;
        }catch(SQLException e){
            throw new RuntimeException("Erro ao buscar todos os produtos", e);
        }
    }

    public void updateProduto(Produto produto){
        String sql = "UPDATE produto SET nome = ?, preco_custo = ?, preco_venda = ?, " +
                "quantidade_atual = ?, estoque_minimo = ?, categoria_id = ? WHERE id = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, produto.getNome());
            stmt.setBigDecimal(2, produto.getPrecoCusto());
            stmt.setBigDecimal(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQuantidadeAtual());
            stmt.setInt(5, produto.getEstoqueMinimo());
            stmt.setInt(6, produto.getCategoria().getId());
            stmt.setInt(7, produto.getId());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar produto", e);
        }
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