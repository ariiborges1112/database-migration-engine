package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory{
    private static final String urlBanco = "jdbc:sqlite:Business-Template.db";

    public Connection conectar(){
        try{
            Connection conexao = DriverManager.getConnection(urlBanco);

            System.out.println("Banco conectado com sucesso!");
            return conexao;
        }catch(SQLException e){
            throw new RuntimeException("Erro fatal ao conectar no banco", e);
        }
    }
}
