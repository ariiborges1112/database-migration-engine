package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory{
    public Connection conectar(){
        try{
            String urlBanco = "jdbc:sqlite:Business-Template.db";
            Connection conexao = DriverManager.getConnection(urlBanco);

            System.out.println("Banco conectado com sucesso!");
            return conexao;
        }catch(SQLException e){
            throw new RuntimeException("Erro fatal ao conectar no banco", e);
        }
    }
}
