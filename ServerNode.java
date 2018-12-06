/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.util.ArrayList;
import java.Thread;

/**
 *
 * @author marks
 */
public class ServerNode extends Node{
    
    private ArrayList<File> fileIndex;
    private int[] buffer = new int[100];
    private int buffdex;

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
    public String findFile() throws InterruptedException {
        //if (fileIndex.contains(filename))
        buffer[buffdex] = buffdex;
        buffdex++;
        //sleeping done here
<<<<<<< HEAD
        Thread.sleep();
=======
        Thread.sleep(5000)
>>>>>>> 76124294d977b3219d20e0c2a99a5662a03b3a20
        buffdex--;
    }
   
}
