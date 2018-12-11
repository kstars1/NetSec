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

    public static void main(String arg) throws InterruptedException {
        //create either defended or undefended servernode
        Thread indexer = null;
        int node_count = 0;
        if (arg.equals("attack")) {
            indexer = new Thread(new ServerNodeAlt("indexer"));
        }
        if (arg.equals("defend")) {
            indexer = new Thread(new ServerNodeM("indexer"));
        } else {
            indexer = new Thread(new ServerNodeAlt("indexer"));
        }
        indexer.start();

        Thread badguy;
        badguy = new Thread(new badNode("badguy", 0));
        node_count++;
        
        Thread goodguy1;
        goodguy1 = new Thread(new goodNode("goodguy1", 1));
        node_count++;
        
        Thread goodguy2;
        goodguy2 = new Thread(new goodNode("goodguy2", 2));
        node_count++;
        
        badguy.start();
        goodguy1.start();
        goodguy2.start();

    }

}
