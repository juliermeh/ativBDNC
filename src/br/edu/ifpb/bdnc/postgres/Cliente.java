/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.postgres;

import java.sql.Date;

/**
 *
 * @author Julierme Heinstein
 */
public class Cliente{
    /* Atributos da classe Cliente */
    private String cpf;
    private String nome;
    private Date datanasc;
    private String email;
    private String senha;
    
    /* Construtor padrão */
    public Cliente(){
    };
    
    /* Contrutor de Cliente que recebe todos os atributos */
    public Cliente(String cpf, String nome, Date datanasc, String email, String senha){
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
    
    public Date getDataNasc(){
        return datanasc;
    }
    public void setDataNasc(Date datanasc){
        this.datanasc = datanasc;
    }
    
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
}
