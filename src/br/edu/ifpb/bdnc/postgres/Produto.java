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
public class Produto {
     /* Atributos da classe Produto */
    private int codigo;
    private String nome;
    private String descricao;
    private float valor;
    
    /* Construtor padrão */
    public Produto(){
    };
    
    /* Contrutor de Produto que recebe todos os atributos */
    public Produto(int codigo, String nome, String descricao, float valor){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }
    
     /* Métodos GET e SET para os atributos declarados na entidade Produto */
    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(int cod){
        this.codigo = cod;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String desc){
        this.descricao = desc;
    }
    
    public float getValor(){
        return valor;
    }
    public void setValor(float valor){
        this.valor = valor;
    }
    
}
