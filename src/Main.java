import java.awt.Component;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame ("Block Brakers");
		
		BlockBrakerPanel panel = new BlockBrakerPanel();
		
		frame.getContentPane().add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(490,600);
		frame.setResizable(false);
		
	}
}
