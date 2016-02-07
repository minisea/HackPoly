import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;
import java.util.TimerTask;
import java.util.Timer;


public class DrawingPanel extends JPanel implements MouseListener, Runnable{
	private boolean draw = false;
	private int x = 0;
	private int y = 0;
	private int dx, dy;
	private int z,w;
	private int size = 200;
	private Thread t;
	private Timer timer;
	private TimerTask task;
	public DrawingPanel()
	{
		this.setBackground(Color.WHITE); 
		addMouseListener(this);
		t = new Thread (this);
		w = 50;
		y = 50;
		dx = 10;
		dy = 0; 
		t.start();
		
	}	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		move();
		
		drawCircle(g, z, w);
		move();
		drawImage(g, 300);
	}
		
		/*timer = new Timer();
		task = new TimerTask(){
			public void run(){
				updateImage(g);
				repaint();
			}
		};
		timer.schedule(task,0,2);

		
	}
	public void updateImage(Graphics g)
	{
		int O = 50;
		drawImage(g,300 + O);
		O += 50;
		
	}
*/
	public void drawImage(Graphics g, int yX){
		BufferedImage img = null;
		try
		{
			img = ImageIO.read(new File("NC.png"));
			g.drawImage(img, w, z, size, size, this);
		}
		catch(IOException e)
		{
			
		}
		//g.drawImage(img, 1000, yX, 100, 100, this);
		
		
	}
	public void drawCircle(Graphics g, int x, int y)
	{
		if(draw)
		{
			for(int i = 1; i < 200; i ++)
			{
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(1));
				if(i % 2 == 0)
				{
					g.setColor(Color.BLACK);
				}
				else if(i % 3 == 0)
				{
					g.setColor(Color.YELLOW);
				}
				else
				{
					g.setColor(Color.RED);
				}
				g.drawOval(800 - x + (i/2), y+(i/4) - 40, 100 +i*2 , 100 - (i/2));
				//g.drawOval(x-40, y-40, 80 , 80);
			}
			g.setColor(Color.BLACK);
			g.fillOval(800 - x + 2, y - 30, 80, 80);
		}
		else
		{
			g.setColor(Color.WHITE);
		}
		
	}
	public void mousePressed(MouseEvent e){
		x = e.getX();
		y = e.getY();
		draw = true;
		repaint();
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		draw = true;
		repaint();
	}
	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		draw = true;
		repaint();
	}
	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		while(true){
			repaint();
			try {
				Thread.sleep(20); //60 fps
			} catch (InterruptedException e) {}
		}
	}
	public void move(){
	// test for edges
		if(dx > 0) {
			if(z > getWidth() - size){
				dx = -dx;
			}
		} else {
			if(z < 0){
				dx = -dx;
			}
		}
		if(dy > 0) {
			if(w > getHeight() - size){
				dy = -dy;
			}
		} else {
			if(w < 0){
				dy = -dy;
			}
		}
		// update position
		z += dx;
		w += dy;
	}
}
