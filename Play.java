package pong;

import javax.swing.JFrame;

public class Play {

	public static void main(String[] args) {
		
		Game g=new Game();
		JFrame fra=new JFrame("Pong!");
		fra.getContentPane().add(g);
		fra.setSize(1600, 940);
		fra.setVisible(true);
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.init();
	

	}

}
