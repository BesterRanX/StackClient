/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackclient.gui;

import javax.swing.JTextArea;

/**
 *
 * @author x.ruan
 */
public class ChatArea extends JTextArea{
    //************ CONSTRUCTORS ***************
    public ChatArea(){
        
    }
    
    public void write(String msg){
        this.append("server: " + msg + "\n");
    }
}
