/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.util.ArrayList;

/**
 *
 * @author marks
 */
public class Node {
    private ArrayList<Node> neighbors;
    private ArrayList<String> files;
    public String name;
    
    public Node(String name){
        neighbors = new ArrayList();
        files = new ArrayList();
        this.name = name;
    }
    public Node(String name,Node n1, Node n2, Node n3){
        neighbors = new ArrayList();
        files = new ArrayList();
        neighbors.add(n1);
        neighbors.add(n2);
        neighbors.add(n3);
        this.name = name;
    }
    
    public ArrayList<Node> getNeighbors(){
        return neighbors;
    }
    public ArrayList<String> getFiles(){
        return files;
    }
    public void addNeighbor(Node n){
        neighbors.add(n);
    }
    public void addFile(String s){
        files.add(s);
        //send file to central database;
    }
    public void removeNeighbor(Node n){
        if (neighbors.contains(n)){
            neighbors.remove(n);
        } else
            System.err.println("Error: node is not a neighbor");
    }
}
