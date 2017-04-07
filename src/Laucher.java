
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.edu.ifpb.bdnc.neo4j.Compra;
import br.edu.ifpb.bdnc.mongodb.Cliente;
import br.edu.ifpb.bdnc.mongodb.ItemCompra;
import br.edu.ifpb.bdnc.postgres.Produto;

/**
 *
 * @author Julierme Heinstein
 */
public class Laucher {
    
    private static Compra compra = new Compra();
    
    public static void main(String [] args){
        
        // Compra 1
        Cliente joao = new Cliente("111.111.111-01","João","<1975-10-23>","joao@eu.com","123");
        Produto notebook = new Produto(1, "Notebook", "preto", 3000);
        Produto mouse = new Produto(2, "Mouse", "azul", 40);

        ItemCompra item1 = new ItemCompra(1, notebook, 1);
        ItemCompra item2 = new ItemCompra(2, mouse, 1);
        
        Compra compra = new Compra(1, joao);
        compra.addItem(item1);
        compra.addItem(item2);
        
        // Compra 2
        Cliente maria = new Cliente("111.121.222-02","Maria","<1990-07-05>","maria@ela.com","012");
        Produto teclado = new Produto(3, "Teclado", "branco", 75);
        
        ItemCompra item3 = new ItemCompra(3, mouse, 1);
        ItemCompra item4 = new ItemCompra(4, teclado,1);
        
        Compra compra2 = new Compra(2, maria);
        compra2.addItem(item3);
        compra2.addItem(item4);
        
        // Compra 3
        Cliente pedro = new Cliente("121.131.333-03","Pedro","<2000-05-19>","reipedro@narnia.com","456");
        Produto monitor = new Produto(4, "Monitor", "4.7 polegadas", 550);
        
        ItemCompra item5 = new ItemCompra(5, monitor, 1);
        ItemCompra item6 = new ItemCompra(6, mouse, 1);
        
        Compra compra3 = new Compra(3, pedro);
        compra3.addItem(item5);
        compra3.addItem(item6);
        
    }
}
