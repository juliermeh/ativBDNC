/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Julierme Heinstein
 */
public class ProdutoPost {
    Connection conexao;

    public ProdutoPost() throws SQLException {
        this.conexao = (Connection) new Connectionsql();
    }
    public String adicionaProduto(Produto produto){
        String sql = "INSERT INTO PRODUTO (codigo,nome,descricao,valor)"
                + "VALUES (1,2,3,4)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,produto.getCodigo());
            statement.setString(2,produto.getNome());
            statement.setString(3,produto.getDescricao());
            statement.setDouble(4,produto.getValor());
            return "Produto Adicionado!";
        } catch (SQLException e){
        }
        return "Produto não adicionado";
    }
    
    public String exluiProduto(int codigo){
        String sql = "DELETE FROM PRODUTO WHERE codigo="+ codigo;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            return "Produto excluído";
        } catch (SQLException e) {
        }
        return "Produto não excluído";
    }
}
