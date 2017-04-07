/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.mongodb;

import org.bson.Document;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Julierme Heinstein
 */
public class ClienteMongo {
    
    MongoDatabase database;
    MongoCollection<Document> collection;
    
    public ClienteMongo(){
        database = (MongoDatabase) new Connectmongo();
        collection = database.getCollection("cliente");
    }
    
    public boolean create(Cliente c){
        collection.insertOne(c.toDocument());
        return true;
    }
    
    public Cliente read(String cpf){
        MongoCursor<Document> cursor = collection.find(eq("_id",cpf));
        Cliente cliente = null;
        if(cursor.hasNext()){
            cliente = new Cliente().fromDocument(cursor.next());
        }
        return cliente;
    }
}
