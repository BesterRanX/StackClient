/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackclient;

/**
 *
 * @author x.ruan
 */
public class Protocol {
    // funzione.contenuto
    public static String MESSAGE = "msg";
    
    public static String getContent(String packet){
        return packet.substring(4);
    }
    
    public static String toMessage(String msg){
        return MESSAGE + "." + msg;
    }
}
