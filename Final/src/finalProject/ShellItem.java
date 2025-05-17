package finalProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShellItem extends AbstractItem{
	private int id = 1;
	private BufferedImage image; 
	public ShellItem() {
		
		try {
			image = ImageIO.read(new File("Final/src/images/greenShellItem.png"));
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
