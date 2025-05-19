
package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BananaItem extends AbstractItem{
	private int id = 2;
	private BufferedImage image; 
	public BananaItem() {
		super();
		try {
			image = ImageIO.read(new File("Final/src/images/bananaPeelItem.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}

	@Override
	protected Image getImage() {
		return image;
	}

	
	
	

}
