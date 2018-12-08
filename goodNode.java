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

    public goodNode(String threadName, ServerNode indexer) {
        thread = new Thread(this, threadName); // (1) Create a new thread.
        this.threadName = threadName;
        server = indexer;
        System.out.println(thread.getName());
        thread.start(); // (2) Start the thread.
    }

    public void run() {

        while (true) {
            ServerNode.buffer.enqueue(this.threadName);
            try {
                thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(goodNode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

