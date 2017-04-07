/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.postgres;

/**
 *
 * @author Julierme Heinstein
 */
public class Endereco {
    /* Atributos da classe Endereco */
    private String cpf;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    private int numero;
    
    /* Construtor padrão */
    public Endereco(){
    };
    
    /* Contrutor de Endereco que recebe todos os atributos */
    public Endereco(String cpf, String rua, String bairro, String cidade, String uf, int num){
        this.cpf = cpf;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = num;
    }
    
    /* Métodos GET e SET para os atributos declarados na entidade Endereco */
    public String getCPF(){
        return cpf;
    }
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    
    public String getRua(){
        return rua;
    }
    public void setRua(String rua){
        this.rua = rua;
    }
    
    public String getBairro(){
        return bairro;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    
    public String getUF(){
        return uf;
    }
    public void setUF(String uf){
        this.uf = uf;
    }
    
    public int getNumero(){
        return numero;
    }
    public void setNumero(int num){
        this.numero = num;
    }
}
