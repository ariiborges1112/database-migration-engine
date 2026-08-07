package dao;

import model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO{
    private Connection conexao;

    public FornecedorDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void insertFornecedor(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedor (nome, cnpj, telefone) VALUES (?, ?, ?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao inserir fornecedor", e);
        }
    }

    public List<Fornecedor> todosFornecedores(){
        String sql = "SELECT * FROM fornecedor";
        List<Fornecedor> fornecedores = new ArrayList<>();

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");
                String telefone = rs.getString("telefone");

                Fornecedor fornecedorConsulta = new Fornecedor(id, nome, cnpj, telefone);
                fornecedores.add(fornecedorConsulta);
            }
            return fornecedores;
        }catch(SQLException e){
            throw new RuntimeException("Erro ao buscar todos os fornecedores", e);
        }
    }

    public void updateFornecedor(Fornecedor fornecedor){
        String sql = "UPDATE fornecedor SET nome = ?, cnpj = ?, telefone = ? WHERE id = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setInt(4, fornecedor.getId());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar fornecedor", e);
        }
    }

    public void deleteFornecedor(Integer id){
        String sql = "DELETE FROM fornecedor where id = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao deletar fornecedor", e);
        }
    }
}