//------
// author @keenan
//---------
package p2p;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class goodNode implements Runnable {

    Thread thread;
    String threadName;
    ServerNode server = new ServerNode("indexer");

    public goodNode() {
        //empty constructor 

    }

    public goodNode(String threadName, ServerNode indexer) {
        thread = new Thread(this, threadName); // (1) Create a new thread.
        this.threadName = threadName;
        server = indexer;
        System.out.println(thread.getName());
        thread.start(); // (2) Start the thread.
    }

    public void run() {

        while (true) {
            QueryFlood.buffer.enqueue(this.threadName);
            try {
                thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(goodNode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void requestFile(String filename) {
        //send request to servernode for file
        //wait for response 
        //when response is receieved, wake up
        //if request is approved, ip address is returned
        //if request is denied, null is returned
        //if response is null, exit with error code
        //if response is not null, request file getFile(filename, IP_address)
        //System.out.println(myName + ": Waiting for the server to find my file...")
        //System.out.println(myName + ": The server couldn't find my file :(")
        //System.out.println(myName + ": ")
        //
    }

    public void getFile(String filename, String IP_address) {
        //send request to node aka sleep 
    }
}