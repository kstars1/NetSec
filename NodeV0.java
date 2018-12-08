package p2p;

import java.util.ArrayList;

/**
 *
 * @author marks
 */
public class NodeV0 {
    private ArrayList<NodeV0> neighbors;
    private ArrayList<String> files;
    public String name;
    
    public NodeV0(String name){
        neighbors = new ArrayList();
        files = new ArrayList();
        this.name = name;
    }
    public NodeV0(String name,NodeV0 n1, NodeV0 n2, NodeV0 n3){
        neighbors = new ArrayList();
        files = new ArrayList();
        neighbors.add(n1);
        neighbors.add(n2);
        neighbors.add(n3);
        this.name = name;
    }
    
    public ArrayList<NodeV0> getNeighbors(){
        return neighbors;
    }
    public ArrayList<String> getFiles(){
        return files;
    }
    public void addNeighbor(NodeV0 n){
        neighbors.add(n);
    }
    public void addFile(String s){
        files.add(s);
        //send file to central database;
    }
    public void removeNeighbor(NodeV0 n){
        if (neighbors.contains(n)){
            neighbors.remove(n);
        } else
            System.err.println("Error: node is not a neighbor");
    }
}
