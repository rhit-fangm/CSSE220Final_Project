
package finalProject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Empty extends AbstractItem {
	
	private BufferedImage image; 
	public Empty() {
		try {
			image = ImageIO.read(new File("Final/src/images/emptyItem.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getImage() {
		return image;
	}
}
