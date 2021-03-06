package p2p;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ServerNode extends Node implements Runnable{
    
    //private ArrayList<File> fileIndex;
    private static Lock lock = new Lock();
    public static Queue buffer = new Queue(100);

    public ServerNode(String name) {
        super(name);
        //fileIndex = new ArrayList<File>();
    }
    public ServerNode(String name, long i, int p, Node n, Node b){
        super(name, i, p, n, b);
    }
    public static void addToBuffer(String s) throws InterruptedException{
        lock.lock();
        
        /*int count = 0;
        for (String array1 : array) {
            if (array1.equals(s)) {
                count++;
            }
        }
        if (count <= 10)*/
        buffer.enqueue(s);
        //System.out.println(buffer.getElement(0));
        //else
          //  System.out.println("Too many requests from " + s + " in Queue, request dropped");
        lock.unlock();
    }
    //public void addIndex(File newFile){
        //fileIndex.add(newFile);
    //}
    public void findFile() throws InterruptedException {
        //if (fileIndex.contains(filename))
        //sleeping done here
        while (true){
        while (buffer.isEmpty()){}
        String requester = (String) buffer.dequeue();
        System.out.println("Serving " + requester + ". buffer size: " + buffer.size());
        Thread.sleep(1000);
        System.out.println("Done serving " + requester + ". buffer size: " + buffer.size());
        }
    }

    @Override
    public void run() {
        try {
            findFile();
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
