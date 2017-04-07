/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.mongodb;

import org.bson.BsonDateTime;
import org.bson.Document;


/**
 *
 * @author Julierme Heinstein
 */
public class DataHora {
    /* Atributos da classe DataHora */
    private int codvenda;
    private BsonDateTime data;
    private BsonDateTime hora;
    
    /* Construtor padrão */
    public DataHora(){
    }
    
    /* Contrutor de DataHora que recebe todos os atributos */
    public DataHora(int codvenda, BsonDateTime data, BsonDateTime hora){
        this.codvenda = codvenda;
        this.data = data;
        this.hora = hora;
    }
    
    /* Métodos GET e SET para os atributos declarados na entidade DataHora */
    public int getCodVenda(){
        return codvenda;
    }
    public void setCodVenda(int codigo){
        this.codvenda = codigo;
    }
    
    public BsonDateTime getData(){
        return data;
    }
    public void setData(BsonDateTime data){
        this.data = data;
    }
    
    public BsonDateTime getHora(){
        return hora;
    }
    public void setHora(BsonDateTime hora){
        this.hora = hora;
    }
    
    public Document toDocument(){
        Document doc = new Document();
        doc.append("_id", codvenda);
        doc.append("data",data);
        doc.append("hora",hora);
              
        return doc;
    }
    
    public DataHora fromDocument(Document doc){
        
        codvenda = doc.getInteger("_id");
        DataHora datahora = new DataHora().fromDocument(doc.get("datahora", Document.class));
               
        return this;
    }
}
