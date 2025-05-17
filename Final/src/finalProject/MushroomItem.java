package finalProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MushroomItem extends AbstractItem{
	private int id = 3;

	private BufferedImage image; 
	public MushroomItem() {
	
		try {
			image = ImageIO.read(new File("Final/src/images/mushroomItem.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getId() {
		return id;
	}
	

	@Override
	protected Image getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	
	
	
}