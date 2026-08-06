package dao;

import model.Categoria;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class CategoriaDAO{
    private Connection conexao;

    public CategoriaDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void insertCategoria(Categoria categoria){
        try{
            PreparedStatement stmt = "INSERT INTO categoria(nome) values (?)";

            conexao.commit();
            conexao.close();
            return ;
        }catch(SQLException e){
            throw new RuntimeException("Erro ao salvar categoria", e);
        }
    }
}