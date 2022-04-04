package itts_socketEx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;

public class Server {
	
	ServerSocket serverSocket; 
	Socket socket; 
	
public void connessione() {
	try {
		serverSocket = new ServerSocket(2000);
		System.out.println("Comunicazioe avviata con successo");
		socket=serverSocket.accept();
		System.out.println("richiesta client con successo");
		
	} catch (IOException e) {
		System.out.println("Comunicazione non avviata");
	}
}

public void chiusura() {
	
	try {
		serverSocket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void scriviChat(String s) {
	
	DataOutputStream dos;
		
	try {
		
		dos = new DataOutputStream(socket.getOutputStream());
		dos.writeBytes(s +"\n");
		
		 
	} catch (IOException e) {
		e.printStackTrace();
	} 
	
}

public String leggiChat() {
	
	String messaggio = null; 
	Scanner sc;
	DataInputStream dis;
	try {
		dis = new DataInputStream(socket.getInputStream());
		sc=new Scanner(dis); 
		messaggio=sc.nextLine(); 
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	return messaggio;
	
}
	
public static void main(String[] args) {
	
	new ServerFrame(); 
	Server se = new Server(); 
	
	//se.connessione();
	//se.chat();
	//se.chiusura();
	
	}

}
