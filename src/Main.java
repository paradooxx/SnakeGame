import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		f.setTitle("Snake");
		f.setBounds(10,10,1280,720);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBackground(Color.BLACK);
		
		GamePlay gameplay = new GamePlay();
		
		f.add(gameplay);
	}
}