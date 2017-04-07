/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.neo4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 *
 * @author Julierme Heinstein
 */
public class CompraNeo {
    private String path;
    GraphDatabaseService graph;
    
    public CompraNeo(){
        path = "/usr/local/neo4j-community-3.0.4/data/databases/graph.db";
        graph = new GraphDatabaseFactory()
                .newEmbeddedDatabase(new File(path));
    }

    public boolean create(Compra c){
        
        try(Transaction tx = graph.beginTx()){
            
            Node cliente = graph.findNode(Label.label("cliente"), "id", c.getUsuario().getCPF());
            if(cliente == null){
                cliente = graph.createNode(Label.label("cliente"));
                cliente.setProperty("id", c.getUsuario().getCPF());
            }
            
            List<Node> produtos = new ArrayList<>();
            
            produtos.stream().map((produto) -> graph.findNode(Label.label("Produto"), "id", produto.getId())).map((produto) -> {
                if(produto==null){
                    produto = graph.createNode(Label.label("Produto"));
                    produto.setProperty("id", produto.getId());
                }
                return produto;
            }).forEachOrdered((produto) -> {
                produtos.add(produto);
            });
            
            for(Node n : produtos){
                cliente.createRelationshipTo(n, TypesRelat.COMPRADO);
            }
            
            tx.success();
            
        }
        
        return true;
        
    }

}
