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
public class ServerNode extends Node{
    
    private ArrayList<File> fileIndex;

    public ServerNode(String name) {
        super(name);
        fileIndex = new ArrayList<File>();
    }
    public ServerNode(String name, Node n1, Node n2, Node n3){
        super(name,n1,n2,n3);
        fileIndex = new ArrayList<File>();
    }
    public void addIndex(File newFile){
        fileIndex.add(newFile);
    }
    public String findFile(String filename){
        if (fileIndex.contains(filename))
    }
   
}
