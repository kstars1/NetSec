/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.util.ArrayList;
public class ServerNode extends Node{
    
    //private ArrayList<File> fileIndex;
    private int[] buffer = new int[100];
    private int buffdex;
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
    public void findFile(String requester) throws InterruptedException {
        //if (fileIndex.contains(filename))
        buffer[buffdex] = buffdex;
        buffdex++;
        lock.lock();
        //sleeping done here
        Thread.sleep(5000);
        System.out.println(requester);
        buffdex--;
        lock.unlock();
        return;
    }
   
}
