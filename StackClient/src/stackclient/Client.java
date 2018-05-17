/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;
import stackclient.gui.ChatArea;
import stackclient.gui.ClientPanel;

/**
 *
 * @author x.ruan
 */
public class Client extends Thread {
    //************* ATTRIBUTES *********
    private Socket socket;
    private BufferedReader socket_reader;
    private PrintWriter socket_writer;
    private ChatArea chatarea;
    
    public Client(){
        
    }
    //*************** OPERATORS ****************
    private String readFromSocket() throws IOException{
        return socket_reader.readLine();
    }
    
    //**************** METHODS *************
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(10);
                String message = readFromSocket();
                System.out.println("sto ricevendo " + message);
                decodeMessage(message);
            } catch (Exception ex) {}
        }
    }
    
    public void connect(String address, int port, ChatArea _chatarea){
        try{
            socket = new Socket(address, 4444);
            //creazione socket
            System.out.println("ClientThread: started");
            System.out.println("Client Socket: " + socket);

            //creazione stream di input da socket
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            socket_reader = new BufferedReader(isr);

            //creazione sream output da socket
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            socket_writer = new PrintWriter(new BufferedWriter(osw), true);
            
            // synchronization with gui
            chatarea = _chatarea;
            
            // start the thread
            start();
            
        } catch(Exception ex){
            System.out.println("connection failed");
        }
    }
    
    public void disconnect(){
        try{
            socket.close();
        } catch(Exception ex){
            System.out.println("closing socket failed");
        }
    }
    
    public void sendMessage(String msg){
        socket_writer.write(Protocol.toMessage(msg));
    }
    
    public void decodeMessage(String packet){
        String content = Protocol.getContent(packet);
        chatarea.write(content);
    }
}
