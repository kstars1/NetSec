/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.util.ArrayList;

/**
 *
 * @author marks
 */
public class Node {
    private String name;    // Node alias
    private long ip;    // Node IPv4
    private int port;   // Node port number
    private Node next;  // Pointer to next adjacent node
    private Node back;  // Pointer to previous adjacent node
    private final long min_ip = 0;  // Minimum IP 0.0.0.0
    private final long max_ip = 4294967295L; // Maximum IP 255.255.255.255
    private final int min_port = 20;    // Arbitrary minimum port
    private final int max_port = 1023;  // Arbitrary maximum port
    
    // Default Node constructor
    public Node(String name){
        name = "";
        next = null;
        back = null;
    }
    // Alternate Node constructor
    public Node(String n, long i, int p, Node next_ptr, Node back_ptr){
        name = n;
        next = next_ptr;
        back = back_ptr;
        // Check if passed params are valid for IP address
        if(i >= min_ip && i <= max_ip){
            ip = i;
        }
        else{
            System.out.println("IP is outside of the available address space. Setting IP to 0.0.0.0 ...");
            ip = min_ip;
        }
        // Check if passed params are valid for port
        if(p >= min_port && p <= max_port){
            port = p;
        }
        else{
            System.out.println("Port is outside of the available port range. Defaulting to port 20");
            port = min_port;
        }
    }
    // Return next adjacent node
    public Node getNext(){
        return this.next;
    }
    // Return previous adjacent node
    public Node getBack(){
        return this.back;
    }
    // Convert numerical value to standard IP address format
    public String IpLongToString(long i){
        return ((ip >> 24 ) & 0xFF) + "." +

        ((ip >> 16 ) & 0xFF) + "." +

        ((ip >>  8 ) & 0xFF) + "." +

        ( ip        & 0xFF);
    }
    // Print all info about node
    public void printNodeInfo(){
        System.out.print("Node Name: " + name + "\n" + "Inet Address: " + IpLongToString(ip) + "\n" + "Port number: " + port);
    }
}
