package dao;

import java.sql.Connection;

public class ProdutoDAO{
    private Connection conexao;

    public ProdutoDAO(Connection conexao){
        this.conexao = conexao;
    }
}