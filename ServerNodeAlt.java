package p2p;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.locks.*;

public class ServerNodeAlt extends Node implements Runnable {

    private static final int MAX_NUM_CONNECTIONS = 10;

    private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantLock bufflock = new ReentrantLock();
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

    public static void addToBuffer(String s, int node_id) throws InterruptedException {
        bufflock.lock();
        try {
            if (connections[node_id] > MAX_NUM_CONNECTIONS) {
                System.out.println("Too many requests for " + s + ", dropping request.");
            } else {
                if (connections[node_id] == 0) {
                    lookupTable[node_id] = s;
                }

                buffer.enqueue(s);
                connections[node_id] += 1;
                //printConnections();
            }
        } finally {
            bufflock.unlock();
        }
    }
    public void findFile() throws InterruptedException {
        //int tick = 2;
        while (true){//tick > 0) {
            while (buffer.isEmpty()) { //have to get out of this to enqueue more
            }
            if (lock.tryLock()) {
                try {
                    lock.lock();
                    try {
                        String requester = (String) buffer.dequeue();

                        int id = -1;
                        for (int i = 0; i < lookupTable.length; i++) {
                            if (lookupTable[i].equals(requester)) {
                                id = i;
                                //System.out.println("Serving node_id " + node_id);
                            }
                        }
                        System.out.println("Serving " + requester + ". buffer size: " + buffer.size());
                        Thread.sleep(1000);
                        connections[id]--;
                        System.out.println("Done serving " + requester + ". buffer size: " + buffer.size());
                        System.out.println("connection[" + requester + "] = " + connections[id]);
                        //tick--;
                    } finally {
                        lock.unlock();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        /*while (!buffer.isEmpty()) {
            System.out.print(buffer.dequeue().toString() + " ");
        }

        System.out.println();
        printConnections();
        printLookupTable();*/
    }

    public static void printConnections() {
        for (int i = 0; i < connections.length; i++) {
            System.out.print(connections[i] + " ");
        }
        System.out.println();
    }
    public static void printLookupTable(){
        for (int i = 0; i < lookupTable.length;i++)
            System.out.print(lookupTable[i] + " ");
        System.out.println();
    }

    @Override
    public void run() {
        try {
            findFile();

        } catch (InterruptedException ex) {
            Logger.getLogger(ServerNodeAlt.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

}
