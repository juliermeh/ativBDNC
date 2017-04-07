/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.neo4j;

import br.edu.ifpb.bdnc.mongodb.MongoObject;
import br.edu.ifpb.bdnc.mongodb.Cliente;
import br.edu.ifpb.bdnc.mongodb.ItemCompra;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Julierme Heinstein
 */
public class Compra implements MongoObject<Compra>{
    private int vendaid;
    private Cliente cliente;
    private List<ItemCompra> itens;

    public Compra() {
        itens = new ArrayList<>();
    }

    public Compra(int id, Cliente cliente) {
        this.vendaid = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public int getId() {
        return vendaid;
    }

    public void setId(int id) {
        this.vendaid = id;
    }

    public Cliente getUsuario() {
        return cliente;
    }

    public void setUsuario(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean addItem(ItemCompra item){
        itens.add(item);
        return true;
    }
    
    public List<ItemCompra> getItens() {
        return itens;
    }
    
    public double getTotal(){
        double total = 0;
        for(ItemCompra item : itens){
            total += item.getProduto().getValor();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + vendaid + ", cliente=" + cliente + ", itens=" + itens + '}';
    }

    public Document toDocument(){
        Document doc = new Document();
        doc.append("_id", vendaid);
        doc.append("usuario", cliente.toDocument());
        
        List<Document> itensDocument = new ArrayList<>();
        for(ItemCompra i : itens){
            itensDocument.add(i.toDocument());
        }
        
        doc.append("itens", itensDocument);
        
        return doc;
    }
    
    public Compra fromDocument(Document doc){
        
        vendaid = doc.getInteger("_id");
        cliente = new Cliente().fromDocument(doc.get("cliente", Document.class));
        
        List<Document> itensDocument = doc.get("itens",List.class);
        
        itensDocument.forEach((_item) -> {
            itens.add(new ItemCompra());
        });
        
        return this;
    }
}
