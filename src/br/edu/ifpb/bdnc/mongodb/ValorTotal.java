/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.mongodb;

import org.bson.Document;

/**
 *
 * @author Julierme Heinstein
 */
public class ValorTotal {
    /* Atributos da classe ValorTotal */
    private int vendaid;
    private float valortotal;
    
    /* Construtor padrão */
    public ValorTotal(){
    }
    
    /* Contrutor de DataHora que recebe todos os atributos */
    public ValorTotal(int vendaid,float valortotal){
        this.vendaid = vendaid;
        this.valortotal = valortotal;
    }
    
     /* Métodos GET e SET para os atributos declarados na entidade ValorTotal */
    public int getVendaID(){
        return vendaid;
    }
    public void setVendaID(int id){
        this.vendaid = id;
    }
    
    public float getValorTotal(){
        return valortotal;
    }
    public void setValorTotal(float total){
        this.valortotal = total;
    }
    
    public Document toDocument(){
        Document doc = new Document();
        doc.append("_id", vendaid);
        doc.append("nome", valortotal);
              
        return doc;
    }
    
    public ValorTotal fromDocument(Document doc){
        
        vendaid = doc.getInteger("_id");
        ValorTotal total = new ValorTotal().fromDocument(doc.get("valortotal", Document.class));
               
        return this;
    }
}
