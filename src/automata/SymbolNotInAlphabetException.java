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
public class SymbolNotInAlphabetException extends Exception{

    @Override
    public String getMessage() {
        return "A Symbol is not in alphabet!";
    }


}
