//------
// author @keenan
//---------
package p2p;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class badNode implements Runnable {

    Thread thread;
    String threadName;

    public badNode(String threadName) {
        thread = new Thread(this, threadName); // (1) Create a new thread.
        this.threadName = threadName;
        System.out.println(thread.getName());
        thread.start(); // (2) Start the thread.
    }

    @Override
    public void run() {

        while (true) {
            try {
                ServerNode.addToBuffer(this.threadName);
            } catch (InterruptedException ex) {
                Logger.getLogger(badNode.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(badNode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

