/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.io.Serializable;
/**
 *
 * @author Samer2
 */
public class Node implements Serializable{
    
    private boolean finity;
    private String name;
    private String type;

    public Node(boolean finity, String name, String category) {
        this.finity = finity;
        this.name = name;
        this.type = category;
    }

    
    public String getCategory() {
        if(type.equals(""))
        return "nothing";
        else return type;
    }

    public String getName() {
        return name;
    }

    public boolean isFinity() {
        return finity;
    }
    
    
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        Node node = (Node)other;
        return (node.equals(node.finity) && name.equals(node.name) && type.equals(node.type));
    }
    
    
}
