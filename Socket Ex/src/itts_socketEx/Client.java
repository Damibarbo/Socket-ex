package itts_socketEx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;

public class Client {
	
	Socket socket;
	
	public void connessione() {
		try {
			socket= new Socket("127.0.0.1", 2000);
			System.out.println("Client avviato con successo"); 
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void chiusura() {
		try {
			socket.close();
		} catch (Exception e) {
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

	/*public void chat() {
		try {
			Scanner sc;  
			Scanner in=new Scanner(System.in); 
			
			sc=new Scanner(socket.getInputStream()); 
			String messaggio=sc.nextLine(); 
			System.out.println("Server: " + messaggio); 
			
			System.out.println("inserisci la risposta da mandare al server");
			String risposta=in.nextLine(); 
			risposta += "\n";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
			dos.writeBytes(risposta);
			
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
	} */
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("interfacciaClient"); 
		Client cl = new Client(); 
		
	}

}
