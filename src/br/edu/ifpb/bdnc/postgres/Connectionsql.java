/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Julierme Heinstein
 */
public class Connectionsql {
    /* Classe que realiza a conexão com o PostgreSQL */
    private String url = "jdbc:postgresql://127.0.0.1:5432/lovymetal";
    private String user = "postgres";
    private String pass = "nightwish";
    
    public Connectionsql() throws SQLException{
        Connection con;
        con = DriverManager.getConnection(url,user,pass);
    }
    
    
}
