//------
// author @keenan
//---------
package p2p;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class badNode implements Runnable {

    Thread thread;
    final String threadName;
    private final int node_id;
    private static final ReentrantLock lock = new ReentrantLock();

    public badNode(String threadName, int num) {
        thread = new Thread(this, threadName); // (1) Create a new thread.
        this.threadName = threadName;
        node_id = num;
    }

    @Override
    public void run() {

        while (true) {
            try {
                if (lock.tryLock()) {
                    try {
                        lock.lock();
                        try {
                            ServerNodeAlt.addToBuffer(this.threadName, node_id);
                        } finally {
                            lock.unlock();
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(badNode.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //thread.sleep(100);
                thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(badNode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
