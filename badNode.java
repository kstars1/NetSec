//------
// author @keenan
//---------

package p2p;

import java.util.ArrayList;
import ServerNode.java;

public class badNode implements Runnable {
        Thread thread;
        public badNode(){
           //empty constructor 

        }
        
        public badNode(String threadName, ServerNode server) {
		thread = new Thread(this, threadName); // (1) Create a new thread.
		System.out.println(thread.getName());
		thread.start(); // (2) Start the thread.
	}

    public void run(){
       while(true)
       {
            server.findfile();
       }
    }

    public void requestFile(String filename){
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
    public void getFile(String filename, String IP_address){
        //send request to node aka sleep 
    }
}
