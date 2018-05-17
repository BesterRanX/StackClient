/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackclient;

import javax.swing.JFrame;
import stackclient.gui.ClientPanel;

/**
 *
 * @author x.ruan
 */
public class StackClient {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Client client = new Client();
        JFrame window = new JFrame();
        ClientPanel clientPanel = new ClientPanel(client);
        
        
        window.setDefaultCloseOperation(2);
        window.add(clientPanel);
        window.validate();
        window.pack();
        window.setVisible(true);
    }
}
