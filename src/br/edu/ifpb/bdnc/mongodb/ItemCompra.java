/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.mongodb;

import org.bson.Document;
import br.edu.ifpb.bdnc.postgres.Produto;

/**
 *
 * @author Julierme Heinstein
 */
public class ItemCompra implements MongoObject<ItemCompra>{
    private int id;
    private Produto produto;
    private int quantidade;

    public ItemCompra() {
    }

    public ItemCompra(int id, Produto produto, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal(){
        return produto.getValor()*quantidade;
    }
    
    @Override
    public String toString() {
        return "ItemCompra{" + "id=" + id + ", produto=" + produto + ", quantidade=" + quantidade + '}';
    }

    @Override
    public Document toDocument() {
        Document doc = new Document();
        doc.append("_id", id);
        doc.append("produto", produto);
        doc.append("quantidade", quantidade);
        return doc;
    }

    @Override
    public ItemCompra fromDocument(Document doc) {
        id = doc.getInteger("_id");
        produto = new Produto();
        quantidade = doc.getInteger("quantidade");
        return this;
    }
}
