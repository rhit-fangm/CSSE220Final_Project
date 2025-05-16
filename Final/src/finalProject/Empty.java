package finalProject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Empty extends AbstractItem {
	private int x,y;
	private BufferedImage image; 
	public Empty(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		try {
			image = ImageIO.read(new File("src/images/brownCar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public BufferedImage getImage() {
		return image;
	}

	
}
