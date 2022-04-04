package itts_socketEx;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BarraStrumentiServer extends JPanel implements ActionListener {
	
	private JButton btnInvio; 
	private JTextField mess; 
	private TextAreaPanel tap; 
	Server se = new Server(); 
	
	public BarraStrumentiServer() {
		btnInvio = new JButton("INVIA"); 
		btnInvio.addActionListener(this); 
		
		mess = new JTextField(); 
		Dimension d= mess.getPreferredSize(); 
		d.width = 400;  
		mess.setPreferredSize(d);
		
		setLayout(new FlowLayout()); 
		
		add(mess); 
		add(btnInvio);
		
		se.connessione();
		while(true) {
			tap.appendiTesto(se.leggiChat());
		}
	}
	
	public void setTextAreaPanel(TextAreaPanel tap) {
		
		this.tap = tap; 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s = mess.getText();
		tap.appendiTesto(s + "\n"); 
		se.scriviChat(s+"\n");
	} 
	
	

}
