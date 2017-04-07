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
public class EnderecoPost {
    Connection conexao;

    public EnderecoPost() throws SQLException {
        this.conexao = (Connection) new Connectionsql();
    }
    public String adicionaEndereco(Endereco endereco){
        String sql = "INSERT INTO ENDERECO (cpf,rua,bairro,cidade,uf,numero)"
                + "VALUES (1,2,3,4,5,6)";
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,endereco.getCPF());
            statement.setString(2,endereco.getRua());
            statement.setString(3,endereco.getBairro());
            statement.setString(4,endereco.getCidade());
            statement.setString(5,endereco.getUF());
            statement.setInt(6,endereco.getNumero());
            return "Endereco Adicionado!";
        } catch (SQLException e){
        }
        return "Endereco não adicionado";
    }
    
    public String exluiEndereco(String cpf){
        String sql = "DELETE FROM ENDERECO WHERE cpf="+ cpf;
        try{
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            return "Endereco excluído";
        } catch (SQLException e) {
        }
        return "Endereco não excluído";
    }
}
