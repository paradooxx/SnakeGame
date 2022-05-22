import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class GamePlay extends JPanel{
	
	private int[] snakeXlength = new int[750];
	private int[] snakeYlength = new int[750];
	
	private boolean top = false;
	private boolean bottom = false;
	private boolean right = false;
	private boolean left = false;
	
	private Timer timer;
	private int delay = 100;
	
	private ImageIcon upMouth;
	private ImageIcon bottomMouth;
	private ImageIcon rightMouth;
	private ImageIcon leftMouth;
	private ImageIcon snakeImage;
	
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
		
		rightMouth = new ImageIcon("images/rightmouth.png");
		rightMouth.paintIcon(this, g, 500, 500);
	}
}
