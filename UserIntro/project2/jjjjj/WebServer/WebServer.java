/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author Jacob Lo
 */
public class WebServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	try {
            //Creates a new server socket with the given port number
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
            Socket socket = serverSocket.accept();
            
            //Now we have established the a connection with the client
            System.out.println("Connection created, client IP: " + socket.getInetAddress());
            
            DataInputStream in = new DataInputStream(socket.getInputStream());
	    String message = in.readUTF();
            System.out.println("Client is " + message);

            //Send a reply to the client
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
	    DataOutputStream outMessage = new DataOutputStream(socket.getOutputStream());
                
            Random r = new Random();
            ArrayList<Reading> readingObj = new ArrayList<>();		 
            int counter = r.nextInt(4);

            while(counter >= 0){
		readingObj.add(new Reading());
		counter--;
            }

	    if(readingObj.size() > 1){
	        message = "Web Server is sending " + readingObj.size() + " reading objects";
	    }else{
		message = "Web Server is sending " + readingObj.size() + " reading object";
	    }
	
	    outMessage.writeUTF(message);
	    outMessage.flush();

            out.writeObject(readingObj);
            out.flush();

            socket.close();
        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            return;
        } catch (IOException ex) {
            System.out.println("Error occured while establishing a connection");
            return;
       	}
    }
    
}
