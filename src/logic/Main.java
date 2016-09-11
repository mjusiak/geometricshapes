/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JPanel;
import view.MainFrame;

/**
 *
 * @author Mati
 */
public class Main {
    ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    DataForm d;
    ArrayList<DataForm> forms = new ArrayList<>();
    JPanel panel;
    Main(){}
    void run()
    {
        try{
            //1. creating a server socket
            providerSocket = new ServerSocket(777);
            //2. Wait for connection
            System.out.println("Waiting for connection");
            connection = providerSocket.accept();
            System.out.println("Connection received from " + connection.getInetAddress().getHostName());
            //3. get Input and Output streams
            out = new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            in = new ObjectInputStream(connection.getInputStream());
            sendMessage("Connection successful");
            //4. The two parts communicate via the input and output streams
            do{
                try{
                    message = (String)in.readObject();
                    switch (message) {
                case "Up":  // handle up
                    d = forms.get(forms.size() - 1);
                    d.y -= 1;
                    d.color = Color.BLACK;
                    break;
                case "Down":  // handle down 
                    d = forms.get(forms.size() - 1);
                    d.y += 1;
                    break;
                case "Left":  // handle left
                    d = forms.get(forms.size() - 1);
                    d.x -= 1;
                    break;
                case "Right":  // handle right
                    d = forms.get(forms.size() - 1);
                    d.x += 1;
                    break;
                default:
                    }
                     panel.repaint();
//                    System.out.println("client>" + message);
//                    if (message.equals("bye"))
//                        sendMessage("bye");
                }
                catch(ClassNotFoundException classnot){
                    System.err.println("Data received in unknown format");
                }
            }while(!message.equals("bye"));
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        finally{
            //4: Closing connection
            try{
                in.close();
                out.close();
                providerSocket.close();
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
    }
    void sendMessage(String msg)
    {
        try{
            out.writeObject(msg);
            out.flush();
            System.out.println("server>" + msg);
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
        Main server = new Main();
        
        ArrayList<DataForm> forms = new ArrayList<>();

        MainFrame mf = new MainFrame();
        Mouse m = new Mouse(mf, mf.panel);
        Keys k = new Keys(mf.panel, forms);

        mf.addKeysListenerToFrame(k);
        mf.addMouseListenerToPanel(m);
        m.setPoints(forms);
        mf.setPoints(forms);
        
        while(true){
            server.run();
        }
    }
}
