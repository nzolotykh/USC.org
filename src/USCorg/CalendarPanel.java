package USCorg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CalendarPanel extends JPanel {
		//Have no idea if we're implementing something so I'm just trolling
			//Love, Priyam
	BufferedImage backimage = null;

	public CalendarPanel() {
		
		try {
			final	BufferedImage usclogo = ImageIO.read(new File("goldblum.jpg"));
			this.backimage = usclogo;
			setSize(usclogo.getWidth(),usclogo.getHeight());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(backimage, 0, 0, null);
		repaint();
		g.drawString("Calendar Panel :D", 40, 30);	
		setForeground(Color.white);	
		g.drawString("<3<3 Jeff Goldblum", 30, 150);
		repaint();

	}

}