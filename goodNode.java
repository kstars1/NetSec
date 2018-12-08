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
    int node_id;

    public goodNode() {
        //empty constructor 

    }

    public goodNode(String threadName, int num) {
        thread = new Thread(this, threadName); // (1) Create a new thread.
        this.threadName = threadName;
        node_id = num;
        System.out.println(thread.getName());
        thread.start(); // (2) Start the thread.
    }

    public void run() {

        while (true) {
            try {
                ServerNode.addToBuffer(this.threadName, node_id);
            } catch (InterruptedException ex) {
                Logger.getLogger(goodNode.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(goodNode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

