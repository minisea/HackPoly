import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Drawing extends JFrame //implements MouseListener
{
	
	private DrawingPanel panel;
	
	public Drawing()
	{
		//window dimensions (x, y, width, height)
		setBounds(50, 20, 1300, 1300);
		panel = new DrawingPanel();
		this.setContentPane(panel);
		//addMouseListener(this);
	}
	public static void main(String[] args) {
		Drawing window = new Drawing();
		
		//sets the title
		window.setTitle("Test ");
		//allows the window to be closed when the 'x' is clicked on
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//sets the window as visible 
		window.setVisible(true);

	}

}
