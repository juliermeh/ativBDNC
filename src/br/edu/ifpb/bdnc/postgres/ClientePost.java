/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.postgres;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Julierme Heinstein
 */
public class ClientePost {
    Connection conexao;

    public ClientePost() throws SQLException {
        this.conexao = (Connection) new Connectionsql();
    }
    public String adicionaCliente(Cliente cliente){
        String sql = "INSERT INTO CLIENTE (cpf,nome,datanasc,senha)"
                + "VALUES (1,2,3,4)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,cliente.getCPF());
            statement.setString(4,cliente.getSenha());
            statement.setString(2,cliente.getNome());
            statement.setDate(3,cliente.getDataNasc());
            return "Cliente Adicionado!";
        } catch (SQLException e){
        }
        return "Cliente não adicionado";
    }
    
    public String exluiCliente(String cpf){
        String sql = "DELETE FROM CLIENTE WHERE cpf="+ cpf +" ON CASCADE";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            return "Cliente excluído";
        } catch (SQLException ex) {
        }
        return "Cliente não excluído";
    }
}
