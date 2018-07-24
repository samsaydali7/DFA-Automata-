/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Samer2
 */
public class Automata implements Serializable {

    /**
     * @param args the command line arguments
     */
    public Node startingNode;
    public Set<Node> states;
    public Set<Node> finityStates;
    public Collection alphabet;

    public Map<Node, Edges> transitions;

    public Automata(Node startingNode, Collection alphabet) {
        this.startingNode = startingNode;
        this.states = new HashSet<Node>();
        this.finityStates = new HashSet<Node>();;
        this.alphabet = alphabet;
        this.transitions = new HashMap<Node, Edges>();
    }

    public void addNode(Node state) {
        this.states.add(state);
        if (state.isFinity()) {
            this.finityStates.add(state);
        }
        this.transitions.put(state, new Edges(state));
    }

    public void addEdge(Node from, Node to, String symbol) {
        if (states.contains(from) && states.contains(to) && alphabet.contains(symbol)) {
            this.transitions.get(from).addEdge(symbol, to);
        }
    }

    public Collection getAlphabet() {
        return alphabet;
    }

    public Node nextState(Node state, String symbol) { //تابع الانتقال
        if (states.contains(state) && alphabet.contains(symbol)) {

            return this.transitions.get(state).getNode(symbol);
        } else {
            return null;
        }
    }

    public Resault match(String string) throws SymbolNotInAlphabetException, NodeNotInSetException {
        Node currentState = startingNode;
        if (!states.contains(currentState)) {
            throw new NodeNotInSetException();
        }
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (!alphabet.contains(String.valueOf(ch))) {
                throw new SymbolNotInAlphabetException();
            }
            if (currentState == null) {
                return new Resault("nothing", false);
            } else if (alphabet.contains(String.valueOf(ch))) {
                currentState = this.nextState(currentState, String.valueOf(ch));
                if (!states.contains(currentState)) {
                    throw new NodeNotInSetException();
                }
                System.out.println(currentState.getName());
            }
        }

        if (currentState != null && currentState.isFinity()) {
            return new Resault(currentState.getCategory(), true);
        }

        return new Resault("nothing", false);
    }
}
