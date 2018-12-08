/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.util.ArrayList;
public class ServerNode extends Node{
    
    //private ArrayList<File> fileIndex;
    private Lock lock = new Lock();

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
    public void findFile() throws InterruptedException {
        //if (fileIndex.contains(filename))
        //sleeping done here
        while (true){
        while (QueryFlood.buffer.isEmpty()){}
        String requester = (String) QueryFlood.buffer.dequeue();
        System.out.println("Serving " + requester + ". buffer size: " + QueryFlood.buffer.size());
        Thread.sleep(1000);
        System.out.println("Done serving " + requester + ". buffer size: " + QueryFlood.buffer.size());
        }
    }
   
}