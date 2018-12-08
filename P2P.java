package p2p;

/**
 *
 * @author aloud
 */
import java.util.*;

public class P2P {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        QueryFlood run = new QueryFlood();
        System.out.println("Enter attack to run the query flood, enter defend to run the mitigated query flood")
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        run.main(input);
    }
    
}