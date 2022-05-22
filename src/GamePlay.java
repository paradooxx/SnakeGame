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
	
	private int moves = 0;
	private int snakeLength = 3;
	
	public GamePlay()
	{
		
	}
	public void paint(Graphics g)
	{
		if(moves == 0)
		{
			snakeXlength[0] = 500;
			snakeXlength[1] = 465;
			snakeXlength[2] = 430;
			
			snakeYlength[0] = 500;
			snakeYlength[1] = 500;
			snakeYlength[2] = 500;
		}
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
		rightMouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
		
		for(int i = 0 ; i < snakeLength ; i++)
		{
			if(i == 0 && right)
			{
				rightMouth = new ImageIcon("images/rightmouth.png");
				rightMouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if(i == 0 && left)
			{
				leftMouth = new ImageIcon("images/leftmouth.png");
				leftMouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if(i == 0 && top)
			{
				upMouth = new ImageIcon("images/topmouth.png");
				upMouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if(i == 0 && bottom)
			{
				bottomMouth = new ImageIcon("images/bottommouth.png");
				bottomMouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if(i != 0)
			{
				snakeImage = new ImageIcon("images/body.png");
				snakeImage.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
		}
		g.dispose();
	}
}
