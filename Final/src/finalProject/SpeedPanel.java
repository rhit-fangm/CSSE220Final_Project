package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpeedPanel extends Obstacle{

	private int x, y;
	private int length, height;
	private BufferedImage image;
	
	public SpeedPanel(int x, int y, int length, int height) {
		super(x,y,length,height);
		try {
			image = ImageIO.read(new File("src/images/speedBoost"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void drawOn(Graphics g) {
		if(image != null) {
			g.drawImage(image, x, y, length, height, this);
		}
	}
}
