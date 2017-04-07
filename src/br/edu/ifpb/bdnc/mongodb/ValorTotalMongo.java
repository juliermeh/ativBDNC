/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Julierme Heinstein
 */
public class ValorTotalMongo {
    
    MongoDatabase database;
    MongoCollection<Document> collection;
    
    public ValorTotalMongo(){
        database = (MongoDatabase) new Connectmongo();
        collection = database.getCollection("valortotal");
    }
    
    public boolean create(ValorTotal total){
        collection.insertOne(total.toDocument());
        return true;
    }
    
    public ValorTotal read(int vendaid){
        MongoCursor<Document> cursor = collection.find(eq("_id",vendaid));
        ValorTotal total = null;
        if(cursor.hasNext()){
            total = new ValorTotal().fromDocument(cursor.next());
        }
        return total;
    }
}
