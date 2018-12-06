//------
// author @keenan
//---------

package p2p;

import java.util.ArrayList;
import ServerNode.java;

public class goodNode implements Runnable {
        Thread thread;
        public goodNode(){
           //empty constructor 

        }
        
        public goodNode(String threadName, ServerNode server) {
		thread = new Thread(this, threadName); // (1) Create a new thread.
		System.out.println(thread.getName());
        ServerNode server = new ServerNode()
		thread.start(); // (2) Start the thread.
	}

    public void run(){
       Thread.sleep(10000)


    }

