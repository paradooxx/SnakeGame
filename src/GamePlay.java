import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class GamePlay extends JPanel implements KeyListener, ActionListener{
	
	private int[] snakeXlength = new int[750];
	private int[] snakeYlength = new int[750];
	
	private boolean up = false;
	private boolean down = false;
	private boolean right = false;
	private boolean left = false;
	
	private Timer timer;
	private int delay = 100;
	
	private ImageIcon upMouth;
	private ImageIcon bottomMouth;
	private ImageIcon rightMouth;
	private ImageIcon leftMouth;
	private ImageIcon snakeImage;
	private ImageIcon enemyImage;
	private ImageIcon titleImage;
	
	private int moves = 0;
	private int snakeLength = 3;
	
	
	private int[] enemyXPos= {20, 55, 90, 125, 160, 195, 230, 265, 300, 335, 370, 405, 440, 475, 510, 545, 580, 615, 650, 685, 720, 755, 790, 825, 860, 895, 930,
								965, 1000, 1035, 1070, 1105, 1140, 1175, 1180};
	
	private int[] enemyYPos = {70, 105, 140, 175, 210, 245, 280, 315, 350, 385, 420, 455, 490, 525, 560, 595, 630};
	
	private Random random=new Random();
	
	private int xPos = random.nextInt(34);
	private int yPos = random.nextInt(17);
	
	public GamePlay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer=new Timer(delay,this);
		timer.start();
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
			if(i == 0 && up)
			{
				upMouth = new ImageIcon("images/topmouth.png");
				upMouth.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
			}
			if(i == 0 && down)
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
		enemyImage = new ImageIcon("images/food(frog).png");
		enemyImage.paintIcon(this, g, enemyXPos[xPos], enemyYPos[yPos]);
		
		if(enemyXPos[xPos] == snakeXlength[0] && enemyYPos[yPos] == snakeYlength[0])
		{
			snakeLength++;
			xPos = random.nextInt(34);
			yPos = random.nextInt(17);
		}
		g.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(right)
		{
			for(int i = snakeLength - 1 ; i >= 0 ; i--)
				snakeYlength[i + 1] = snakeYlength[i];
			for(int i = snakeLength ; i >= 0 ; i--)
			{
				if(i == 0)
					snakeXlength[i] = snakeXlength[i] + 35;
				else
					snakeXlength[i] = snakeXlength[i - 1];
				if(snakeXlength[i] > 1180)
					snakeXlength[i] = 20;
			}
			repaint();
		}
		if(left)
		{
			for(int i = snakeLength - 1 ; i >= 0 ; i--)
				snakeYlength[i + 1] = snakeYlength[i];
			for(int i = snakeLength ; i >= 0 ; i--)
			{
				if(i == 0)
					snakeXlength[i] = snakeXlength[i] - 35;
				else
					snakeXlength[i] = snakeXlength[i - 1];
				if(snakeXlength[i] < 20)
					snakeXlength[i] = 1180;
			}
			repaint();
		}
		if(up)
		{
			for(int i = snakeLength - 1 ; i >= 0 ; i--)
				snakeXlength[i + 1] = snakeXlength[i];
			for(int i = snakeLength ; i >= 0 ; i--)
			{
				if(i == 0)
					snakeYlength[i] = snakeYlength[i] - 35;
				else
					snakeYlength[i] = snakeYlength[i - 1];
				if(snakeYlength[i] < 70)
					snakeYlength[i] = 630;
			}
			repaint();
		}
		if(down)
		{
			for(int i = snakeLength - 1 ; i >= 0 ; i--)
				snakeXlength[i + 1] = snakeXlength[i];
			for(int i = snakeLength ; i >= 0 ; i--)
			{
				if(i == 0)
					snakeYlength[i] = snakeYlength[i] + 35;
				else
					snakeYlength[i] = snakeYlength[i - 1];
				if(snakeYlength[i] > 630)
					snakeYlength[i] = 70;
			}
			repaint();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moves++;
			if(!left)
			{
				right = true;
				
			}
			else
			{
				right = false;
				left = true;
			}
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moves++;
			if(!right)
			{
				left = true;
				
			}
			else
			{
				left = false;
				right = true;
			}
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			moves++;
			if(!down)
			{
				up = true;
				
			}
			else
			{
				down = true;
				up = false;
			}
			right = false;
			left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moves++;
			if(!up)
			{
				down = true;
				
			}
			else
			{
				up = true;
				down = false;
			}
			right = false;
			left = false;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}