
package finalProject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ItemBox extends Obstacle{
	private int x, y;
	private int length, height;
	private BufferedImage image;
	
	public ItemBox(int x, int y, int length, int height) {
		super(x,y,length,height);
		try {
			image = ImageIO.read(new File("Final/src/images/itemBox.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public BufferedImage getImage() {
		return image;
	}
	

	@Override
	protected void drawOn(Graphics g) {
		if(image != null) {
			g.drawImage(image, x, y, length, height, this);
			
		}
		else {
			g.fillRect(x, y, length, height);
		}
		
	
	}

	@Override
	protected void collide(Vehicle player) {
		int randNum = (int) (Math.random()*3);
		switch(randNum) {
		case 0: player.setItem(new MushroomItem()); break;
		case 1: player.setItem(new ShellItem()); break;
		case 2: player.setItem(new BananaItem()); break;
		}

	}
	
	
}
