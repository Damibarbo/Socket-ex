package itts_socketEx;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerFrame extends JFrame {
	 
	public TextAreaPanel chat; 
	public BarraStrumentiServer bs; 
	Server se = new Server();  
	
	public ServerFrame() {
		
		super("frameServer"); 
		
		setLayout(new BorderLayout()); 
				
		chat=new TextAreaPanel(); 
		bs = new BarraStrumentiServer();
		bs.setTextAreaPanel(chat);
		chat.setAutoscrolls(true);
		
		add(chat,BorderLayout.CENTER);
		add(bs,BorderLayout.PAGE_END); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
	}

}
