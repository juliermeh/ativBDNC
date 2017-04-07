/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author Julierme Heinstein
 */
public class Connectmongo {

    /* Classe que realiza a conexão com o MongoDB */
    MongoClient mongoClient;
    MongoDatabase database;

    /* Construtor responsável pela conexão */
    public MongoDatabase Connectmongo() {
        mongoClient = new MongoClient("localhost", 27017);
        database = mongoClient.getDatabase("ativBDNC");
        return database;
    }
}
