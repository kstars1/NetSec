//------
// author @keenan
//---------
package p2p;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class goodNode implements Runnable {

    Thread thread;
    String threadName;
    int node_id;
    private static final ReentrantLock lock = new ReentrantLock();

    public goodNode(String threadName, int num) {
        thread = new Thread(this, threadName); // (1) Create a new thread.
        this.threadName = threadName;
        node_id = num;
    }

    @Override
    public void run() {

        while (true) {
            try {
                lock.lock();
                try {
                    ServerNodeAlt.addToBuffer(this.threadName, node_id);
                } finally {
                    lock.unlock();
                }
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
