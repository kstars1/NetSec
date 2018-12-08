package p2p;

/**
 *
 * @author keenan
 */


public class QueryFlood {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String arg) throws InterruptedException {
        if(arg = "attack")
            ServerNode indexer = new ServerNode("indexer");
        else if(arg = "defend")
            ServerNode2 indexer = new ServerNode2("indexer");
        Thread badguy;
        badguy = new Thread(new badNode("badguy",indexer));
        Thread goodguy1;
        goodguy1 = new Thread(new goodNode("goodguy1", indexer));
        Thread goodguy2;
        goodguy2 = new Thread(new goodNode("goodguy2", indexer));
        indexer.findFile();
        badguy.start();
        goodguy1.start();
        goodguy2.start();

        }
    
}