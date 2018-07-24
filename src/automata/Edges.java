/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Samer2
 */
public class Edges implements Serializable{

    Node from;
    Map<String,Node> edges;

    public Edges(Node from) {
        this.from = from;
        this.edges = new HashMap<String,Node>();
    }
    public void addEdge(String symbol,Node to){
        this.edges.put(symbol, to);
    }
    public Node getNode(String symbol){
        if(edges.keySet().contains(symbol)){
            return edges.get(symbol);
        }
        return null;
    }
}
