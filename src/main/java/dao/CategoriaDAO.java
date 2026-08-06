package dao;

import model.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO{
    private Connection conexao;

    public CategoriaDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void insertCategoria(Categoria categoria){
        String sql = "INSERT INTO categoria (nome) values (?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, categoria.getNome());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao salvar categoria", e);
        }
    }

    public List<Categoria> todasCategoria(){
        String sql = "SELECT * FROM categoria";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            List<Categoria> categoriaConsulta = new ArrayList<>();

            while(rs.next()){
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");

                Categoria consulta = new Categoria(id, nome);
                categoriaConsulta.add(consulta);
            }
            return categoriaConsulta;
        }catch(SQLException e){
            throw new RuntimeException("Erro ao buscar todas as categoria", e);
        }
    }
}