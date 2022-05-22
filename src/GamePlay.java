import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePlay extends JPanel{
	
	public GamePlay()
	{
		
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 1214, 55);
	}
}
