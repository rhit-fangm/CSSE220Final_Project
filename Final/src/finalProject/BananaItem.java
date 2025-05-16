package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BananaItem extends AbstractItem{
	private int x,y;
	private BufferedImage image; 
	public BananaItem(int x, int y) {
		super(x, y);
		try {
			image = ImageIO.read(new File("src/images/blueCar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image != null) {
			g.drawImage(image, x, y, this);
		}
	}

	@Override
	protected Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
