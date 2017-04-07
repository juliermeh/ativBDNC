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
public class Cliente {
    /* Atributos da classe Cliente */
    private String cpf;
    private String nome;
    private BsonDateTime datanasc;
    private String email;
    private String senha;
    
    /* Construtor padrão */
    public Cliente(){
    };
    
    /* Contrutor de Cliente que recebe todos os atributos */
    public Cliente(String cpf, String nome, BsonDateTime datanasc, String email, String senha){
        this.cpf = cpf;
        this.nome = nome;
        this.datanasc = datanasc;
        this.senha = senha;
    }
    
    /* Métodos GET e SET para os atributos declarados na entidade Cliente */
    public String getCPF(){
        return cpf;
    }
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public BsonDateTime getDataNasc(){
        return datanasc;
    }
    public void setDataNasc(BsonDateTime datanasc){
        this.datanasc = datanasc;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    
    public Document toDocument(){
        Document doc = new Document();
        doc.append("_id", cpf);
        doc.append("nome",nome);
        doc.append("datanasc",datanasc);
        doc.append("senha",senha);
              
        return doc;
    }
    
    public Cliente fromDocument(Document doc){
        
        cpf = doc.getString("_id");
        Cliente cliente = new Cliente().fromDocument(doc.get("cliente", Document.class));
               
        return this;
    }
}
