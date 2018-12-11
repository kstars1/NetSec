/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerNodeAlt extends Node implements Runnable {

    //private ArrayList<File> fileIndex;
    private static final int MAX_NUM_CONNECTIONS = 10;
    private static Lock lock = new Lock();
    public static Queue buffer = new Queue(100);
    private static int[] connections = new int[MAX_NUM_CONNECTIONS];
    private static String[] lookupTable = new String[MAX_NUM_CONNECTIONS];

    public ServerNodeAlt(String name) {
        super(name);
        for (int j = 0; j < connections.length; j++) {
            connections[j] = 0;
        }
        for (int j = 0; j < lookupTable.length; j++) {
            lookupTable[j] = "";
        }
    }

    public ServerNodeAlt(String name, long i, int p, Node n, Node b) {
        super(name, i, p, n, b);

    }

    public static void addToBuffer(String s, int node_id) throws InterruptedException {
        lock.lock();
        if (node_id > MAX_NUM_CONNECTIONS) {
            System.out.println("Connection refused");
        } else {
            if (connections[node_id] > 5) {
                System.out.println("Too many requests for " + s + ", dropping request.");
                return;
            } else if (connections[node_id] == 0) {
                lookupTable[node_id] = s;
            }
            buffer.enqueue(s);
            connections[node_id]++;
        }
        lock.unlock();
    }

    //public void addIndex(File newFile){
    //fileIndex.add(newFile);
    //}
    public void findFile() throws InterruptedException {
        //if (fileIndex.contains(filename))
        //sleeping done here
        while (true) {
            while (buffer.isEmpty()) {
            }
            String requester = (String) buffer.dequeue();
            int node_id = -1;
            for (int i = 0; i < lookupTable.length; i++) {
                if (lookupTable[i].equals(requester)) {
                    node_id = i;
                }
            }
            if (node_id < 0) {
                return;
            }
            connections[node_id]--;
            System.out.println("Serving " + requester + ". buffer size: " + buffer.size());
            Thread.sleep(1000);
            System.out.println("Done serving " + requester + ". buffer size: " + buffer.size());
        }
    }

    @Override
    public void run() {
        try {
            findFile();
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerNodeAlt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
