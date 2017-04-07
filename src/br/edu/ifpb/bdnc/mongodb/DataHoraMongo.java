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
public class DataHoraMongo {
    
    MongoDatabase database;
    MongoCollection<Document> collection;
    
    public DataHoraMongo(){
        database = (MongoDatabase) new Connectmongo();
        collection = database.getCollection("datahora");
    }
    
    public boolean create(DataHora dt){
        collection.insertOne(dt.toDocument());
        return true;
    }
    
    public DataHora read(int codvenda){
        MongoCursor<Document> cursor = collection.find(eq("_id",codvenda));
        DataHora datahora = null;
        if(cursor.hasNext()){
            datahora = new DataHora().fromDocument(cursor.next());
        }
        return datahora;
    }
}
