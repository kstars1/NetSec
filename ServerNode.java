package p2p;

import java.util.ArrayList;
public class ServerNode extends Node{

    public static Queue buffer = new Queue(100);

    public ServerNode(String name) {
        super(name);
    }
    public ServerNode(String name, long i, int p, Node n, Node b){
        super(name, i, p, n, b);
    }
    public void addToBuffer(String s){
        buffer.enqueue(s);
    }

    public void findFile() throws InterruptedException {
        while (true){
        while (buffer.isEmpty()){}
        String requester = (String) buffer.dequeue();
        System.out.println("Serving " + requester + ". buffer size: " + buffer.size());
        Thread.sleep(1000);
        System.out.println("Done serving " + requester + ". buffer size: " + buffer.size());
        }
    }
   
}