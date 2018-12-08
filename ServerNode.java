/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.util.ArrayList;
public class ServerNode extends Node implements Runnable{
    
    //private ArrayList<File> fileIndex;
    

    public ServerNode(String name) {
        super(name);
        //fileIndex = new ArrayList<File>();
    }
    public ServerNode(String name, long i, int p, Node n, Node b){
        super(name, i, p, n, b);
        //fileIndex = new ArrayList<File>();
    }
    //public void addIndex(File newFile){
        //fileIndex.add(newFile);
    //}
    public void findFile(String requester) throws InterruptedException {
        //if (fileIndex.contains(filename))
        //sleeping done here
        Thread.sleep(5000);
        System.out.println(requester);
        return;
    }
   
}
