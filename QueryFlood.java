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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerNode indexer = new ServerNode("indexer");
        Thread badguy = new Thread(badNode(), "badguy");
        Thread goodguy1 = new Thread(goodNode(), "goodguy1");
        Thread goodguy2 = new Thread(goodNode(), "goodguy2");
        badguy.start();
        goodguy1.start();
        goodguy2.start();

        }
    
}