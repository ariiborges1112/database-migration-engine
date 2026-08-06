package dao;

import model.Categoria;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;

public class CategoriaDAO{
    private Connection conexao;

    public CategoriaDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void insertCategoria(Categoria categoria){
        String sql = "INSERT INTO categoria(nome) values (?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, categoria.getNome());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao salvar categoria", e);
        }
    }

    public List<Categoria> selectCategoria(Categoria categoria){

    }
}