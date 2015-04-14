package USCorg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LogoPanel extends JPanel {
	
	BufferedImage backimage = null;
		//i'll customize this to look nice once we polish everything else

	public LogoPanel() {
		
		try {
			final	BufferedImage usclogo = ImageIO.read(new File("USC.jpg"));
			this.backimage = usclogo;
			setSize(usclogo.getWidth(),usclogo.getHeight());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Color cardinal = new Color(153, 27, 30);
		setBackground(cardinal);
		//super.setBackground(Color.);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(backimage, 0, 0, null);

	}

}
