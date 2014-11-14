package part4;
//import everything 
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class part4 extends JFrame
{
	//this is the constant that will hold the screen size
	final int WIDTH= 900, HEIGHT = 650;
	
	double p1Speed=.5, p2Speed=.5;
	
	//directions
	final int UP=0, RIGHT=1,DOWN=2, LEFT=3;
	
	int p1Direction=UP;
	int p2Direction=UP;
	
	Rectangle left = new Rectangle (0,0, WIDTH/9, HEIGHT);
	Rectangle right= new Rectangle( (WIDTH/9)*9, 0,WIDTH/9, HEIGHT);
	Rectangle top = new Rectangle (0,0, WIDTH, HEIGHT/9);
	Rectangle bottom = new Rectangle (0,0, HEIGHT/9, WIDTH);
	Rectangle center = new Rectangle ((int)((WIDTH/9)*2.5), (int)((HEIGHT/9)*2.5),(int)((WIDTH/9)*5), (HEIGHT/9)*4 );
	
	//OBSTACLES
	Rectangle obstacle= new Rectangle(WIDTH/2,(int)((HEIGHT/9)*7), WIDTH/10,HEIGHT/9);
	Rectangle obstacle2= new Rectangle(WIDTH/3,(int)((HEIGHT/9)*5), WIDTH/10,HEIGHT/4);
	Rectangle obstacle3= new Rectangle(2*(WIDTH/3),(int)((HEIGHT/9)*5), WIDTH/10,HEIGHT/4);
	Rectangle obstacle4= new Rectangle(WIDTH/3,HEIGHT/9, WIDTH/30,HEIGHT/9);
	Rectangle obstacle5= new Rectangle(WIDTH/2,(int)((HEIGHT/9)*1.5), WIDTH/30,HEIGHT/4);
	
	//the finish the line for both player
	Rectangle finish = new Rectangle(WIDTH/9, (HEIGHT/2)-HEIGHT/9, (int)((WIDTH/9)*1.5), HEIGHT/70);
	
	//START LINE OUTER PLAYER
	
	Rectangle LineO= new Rectangle(WIDTH/9, HEIGHT/2, (int)((WIDTH/9)*1.5)/2, HEIGHT/140);
	
	//START FOR INNER PLAYER
	
	Rectangle LineI= new Rectangle(((WIDTH/9)+((int)((WIDTH/9)*1.5)/2)), (HEIGHT/2)+ (HEIGHT/10), (int)((WIDTH/9)*1.5)/2, HEIGHT/140);
	
	//player 1 outer player
	Rectangle p1= new Rectangle(WIDTH/9, HEIGHT/2, WIDTH/30, WIDTH/30);
	//player 2
	Rectangle p2= new Rectangle(((WIDTH/9)+((int)((WIDTH/9)*1.5)/2)),(HEIGHT/2)+(HEIGHT/10),WIDTH/30,WIDTH/30);
	
	//THE CONSTRUCTOR
	public part4()
	{
		//the following code creates the JFrame
		super("Radical Racing");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//START THE INNER CLASS WORKS ON ITS OWN BECAUSE IS A THREAD
		Move1 m1=new Move1();
		Move2 m2=new Move2();
		
		m1.start();
		m2.start();		
	}
	//this will draw the cars  and the race track
	public void paint(Graphics g)
	{
		super.paint(g);
		
		//draw the background for the racetrack
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WIDTH,HEIGHT);
		
		//WHEN WE DRAW, THE BORER WILLBE GREEN 
		g.setColor(Color.GREEN);
		
		//now, using the rectangles, draw it
		g.fillRect(left.x, left.y, left.width, left.height);
		g.fillRect(right.x, right.y, right.width, right.height);
		g.fillRect(top.x, top.y, top.width, top.height);
		g.fillRect(bottom.x, bottom.y, bottom.width, bottom.height);
		g.fillRect(center.x, center.y, center.width, center.height);
		g.fillRect(obstacle.x, obstacle.y,obstacle.width,obstacle.height);
		g.fillRect(obstacle2.x,obstacle2.y,obstacle2.width,obstacle.height);
		g.fillRect(obstacle3.x, obstacle3.y, obstacle3.width, obstacle3.height);
		g.fillRect(obstacle4.x, obstacle4.y, obstacle4.width, obstacle4.height);
		g.fillRect(obstacle5.x, obstacle5.y, obstacle5.width, obstacle5.height);
		
		//set the starting line to color
		g.setColor(Color.WHITE);
		
		//now draw  the starting line
		g.fillRect(LineO.x,LineO.y, LineO.width, LineO.height);
		g.fillRect(LineI.x,LineI.y, LineI.width, LineI.height);
		//finish line to zero
		g.setColor(Color.YELLOW);
		//now draw finish line
		g.fillRect(finish.x, finish.y, finish.width,finish.height );	
		
		//set color for outer p1
		g.setColor(Color.BLUE);
		//actual player
		g.fill3DRect(p1.x, p1.y, p1.width, p1.height, true);
		
		//set color for p2
		g.setColor(Color.RED);
		
		//draw actual player
		g.fill3DRect(p2.x, p2.y, p2.width, p2.height, true);
		
		
		
	}
	private class Move1 extends Thread implements KeyListener
	{
		public void run()
		{
		//keyListener wake up
		addKeyListener(this);
		//repeats
		while(true)
		{
			try
			{
				//refresh the screen
				repaint();
				//
				if(p1.intersects(left)||p1.intersects(right)||p1.intersects(top)||p1.intersects(bottom)||
						p1.intersects(obstacle)||p1.intersects(obstacle2)||p1.intersects(p2) ||p1.intersects(obstacle3)||p1.intersects(obstacle4)||
						p1.intersects(obstacle5))
				{
					p1Speed=-4;
				}
				if(p1.intersects(center))
				{
					p1Speed=-2.5;
				}
				
				//increase speed
				if(p1Speed<=5)
					p1Speed+=.2;
				
				if(p1Direction==UP)
				{
					p1.y-=(int)p1Speed;
				}
				if(p1Direction==DOWN)
				{
					p1.y+=(int)p1Speed;
				}
				if(p1Direction==LEFT)
				{
					p1.x-=(int)p1Speed;
				}
				if(p1Direction==RIGHT)
				{
					p1.x+=(int)p1Speed;
				}
				
				//delays
				Thread.sleep(75);
				
			}
			catch(Exception e)
			{
				break;
			}
		}
	}
		public void keyPressed(KeyEvent event)
		{	
		}
		public void keyReleased(KeyEvent event)
		{	
		}
		//for key Listener
		public void keyTyped(KeyEvent event)
		{
			if(event.getKeyChar()=='a')
			{
				p1Direction= LEFT;
			}
			
			if(event.getKeyChar()=='s')
			{
				p1Direction= DOWN;
			}
			if(event.getKeyChar()=='d')
			{
				p1Direction= RIGHT;
			}
			if(event.getKeyChar()=='w')
			{
				p1Direction= UP;
			}
		}
	}
	
	private class Move2 extends Thread implements KeyListener
	{
		public void run()
		{
		//keyListener wake up
		addKeyListener(this);
		//repeats
		while(true)
		{
			try
			{
				//refresh the screen
				repaint();
				//
				if(p2.intersects(left)||p2.intersects(right)||p2.intersects(top)||p2.intersects(bottom)||
						p2.intersects(obstacle)||p2.intersects(obstacle2)|| p1.intersects(p2)||p1.intersects(obstacle3)||p1.intersects(obstacle4)||
						p1.intersects(obstacle5)||p2.intersects(obstacle5)||p2.intersects(obstacle4)||p2.intersects(obstacle3))
				{
					p2Speed=-4;
				}
				if(p2.intersects(center))
				{
					p2Speed=-2.5;
				}
				
				//increase speed
				if(p2Speed<=5)
					p2Speed+=.2;
				
				if(p2Direction==UP)
				{
					p2.y-=(int)p1Speed;
				}
				if(p1Direction==DOWN)
				{
					p2.y+=(int)p1Speed;
				}
				if(p2Direction==LEFT)
				{
					p2.x-=(int)p1Speed;
				}
				if(p2Direction==RIGHT)
				{
					p2.x+=(int)p1Speed;
				}
				
				//delays
				Thread.sleep(75);
				
			}
			catch(Exception e)
			{
				break;
			}
		}
	}
		public void keyPressed(KeyEvent event)
		{	
		}
		public void keyReleased(KeyEvent event)
		{	
		}
		//for key Listener
		public void keyTyped(KeyEvent event)
		{
			if(event.getKeyChar()=='j')
			{
				p1Direction= LEFT;
			}
			
			if(event.getKeyChar()=='k')
			{
				p1Direction= DOWN;
			}
			if(event.getKeyChar()=='l')
			{
				p1Direction= RIGHT;
			}
			if(event.getKeyChar()=='i')
			{
				p1Direction= UP;
			}
		}
	}
	
	
	//calls the constructor
	public static void main(String[] args)
	{
		new part4();
	}
	
	
}
