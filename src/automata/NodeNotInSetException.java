/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

/**
 *
 * @author Samer2
 */
public class NodeNotInSetException extends Exception{
    @Override
    public String getMessage() {
        return "A Node is not in States Set!";
    }
}
