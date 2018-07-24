package automata;

import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class FileToObject
{

    private String startingNode;

    private char[] alphabit;

    private ArrayList<Node> states;

    private Map<String,Map<String,String>> transitions;


    public ArrayList<Node> getStates ()
    {
        return states;
    }


    public Map<String,Map<String,String>> getTransitions ()
    {
        return transitions;
    }

    public String getStartingNode ()
    {
        return startingNode;
    }



    public char[] getAlphabit ()
    {
        return alphabit;
    }

}