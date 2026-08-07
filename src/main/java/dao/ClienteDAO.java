package dao;

import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO{
    private Connection conexao;

    public ClienteDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void insertCliente(Cliente cliente){
        String sql = "INSERT INTO cliente (nome, cpf, telefone) VALUES (?, ?, ?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao salvar cliente", e);
        }
    }

    public List<Cliente> todosClientes(){
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<>();

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");

                Cliente clienteConsulta = new Cliente(id, nome, cpf, telefone);
                clientes.add(clienteConsulta);
            }
            return clientes;
        }catch(SQLException e){
            throw new RuntimeException("Erro ao buscar todos os clientes", e);
        }
    }

    public void updateCliente(Cliente cliente){
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ? WHERE id = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getId());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar cliente", e);
        }
    }

    public void deleteCliente(Integer id){
        String sql = "DELETE FROM cliente where id = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao deletar cliente", e);
        }
    }
}