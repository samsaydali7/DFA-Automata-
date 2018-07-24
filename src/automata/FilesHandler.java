/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.google.gson.*;
import org.json.simple.parser.*;

public class FilesHandler {

    public static Automata readFromFile(String path) throws Exception {
        HashSet alphabet = new HashSet();
        HashMap<String, Node> nodes = new HashMap<String, Node>();

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(path));
            String s = obj.toString();

            FileToObject data = new Gson().fromJson(s, FileToObject.class);

            System.out.println("");
            System.out.println("My Automata's Nodes:");
            for (Node node : data.getStates()) {
                System.out.println("name: " + node.getName() + " is finity: " + node.isFinity() + " category: " + node.getCategory());
            }

            ///building the automata ///
            //** alphabet
            for (char c : data.getAlphabit()) {
                alphabet.add(String.valueOf(c));
            }

            //**Map of states ///
            for (Node node : data.getStates()) {
                nodes.put(node.getName(), node);
            }

            Automata auto = new Automata(nodes.get(data.getStartingNode()), alphabet); // starting node , alphabet

            for (Node node : data.getStates()) {
                auto.addNode(node);
                if (node.isFinity()) {
                    auto.finityStates.add(node);
                }
            }

            for (Map.Entry<String, Map<String, String>> entry : data.getTransitions().entrySet()) {
                for (Map.Entry<String, String> entry2 : entry.getValue().entrySet()) {
                    auto.addEdge(nodes.get(entry.getKey()), nodes.get(entry2.getValue()), entry2.getKey());
                }
            }
            System.out.println("");
            System.out.println("My Automata's Edges:");
            for (Map.Entry<String, Map<String, String>> entry : data.getTransitions().entrySet()) {
                for (Map.Entry<String, String> entry2 : entry.getValue().entrySet()) {
                    System.out.println("From: " + nodes.get(entry.getKey()).getName() + " To: " + nodes.get(entry2.getValue()).getName() + " Symbol: " + entry2.getKey());

                }
            }

            return auto;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
