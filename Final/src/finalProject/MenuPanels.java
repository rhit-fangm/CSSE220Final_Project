package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class MenuPanels extends JPanel{
private BufferedImage image;
	
	public MenuPanels() {
		setPreferredSize(new Dimension(1920,1080));
		try {
			image = ImageIO.read(new File("src/images/titlepage.png"));
		} catch (IOException e) {
			System.err.println("Caught: " + e.getMessage());
			e.printStackTrace();
			image = null;
		}
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(getGraphics());
		if(image != null) {
			
			g.drawImage(image, 0, 0, this);
		} else {
			//setBackground(Color.RED);
			g.setColor(Color.BLACK);
			g.drawString("Image not Found", 100, 100);
		}
	}
}
