/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

/**
 *
 * @author keenan
 */


public class QueryFlood {
    public static Queue buffer = new Queue(100);
    /**
     * @param args the command line arguments
     */
    
    public static void main() throws InterruptedException {
        ServerNode indexer = new ServerNode("indexer");
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