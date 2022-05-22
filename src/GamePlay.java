import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class GamePlay extends JPanel{
	
	private ImageIcon titleImage;
	public GamePlay()
	{
		
	}
	public void paint(Graphics g)
	{
		//title image 
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 1214, 55);
		
		titleImage = new ImageIcon("images/title.png");
		titleImage.paintIcon(this, g, 25, 11);
		
		//gameplay window
		g.setColor(Color.WHITE);
		g.drawRect(24, 73, 1214, 600);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(25, 75, 1213, 598);
	}
}
