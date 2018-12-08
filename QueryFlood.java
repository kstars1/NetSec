package p2p;

/**
 *
 * @author keenan
 */


public class QueryFlood {
    //public static Queue buffer = new Queue(100);
    /**
     * @param args the command line arguments
     */
    
    public static void main() throws InterruptedException {
        Thread indexer;
        indexer = new Thread(new ServerNode("indexer"));
        Thread badguy;
        badguy = new Thread(new badNode("badguy"));
        Thread goodguy1;
        goodguy1 = new Thread(new goodNode("goodguy1"));
        Thread goodguy2;
        goodguy2 = new Thread(new goodNode("goodguy2"));
        //indexer.findFile();
        indexer.start();
        badguy.start();
        goodguy1.start();
        goodguy2.start();

        }
    
}