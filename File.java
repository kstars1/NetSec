/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

/**
 *
 * @author marks
 */
public class File {
    
    private String filename;
    private Node location;
    
    public File(String filename, Node location){
        this.filename = filename;
        this.location = location;
    }
    public String getFilename(){
        return filename;
    }
    public String getLocation(){
        return location.name;
    }
}
