package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bush extends Obstacle{

	private int x, y;
	private int length, height;
	private BufferedImage image;
	private GamePanel panel;
	public Bush(int x, int y, int length, int height) {
		super(x,y,length,height);
		
		try {
			image = ImageIO.read(new File("src/images/bush.png"));
		} catch (IOException e) {
			System.out.println("image does not exist");
			e.printStackTrace();
		}
	}
	public BufferedImage getImage() {
		return image;
	}
	
	public void drawOn(Graphics g) {
		if(image != null) {

			g.drawImage(image, x, y, length, height, panel);
			
		}
		else {
			g.fillRect(x, y, length, height);
		}
		
	}
	@Override
	protected void collide(Vehicle player) {
		player.changeX(-player.getVelocity()*Math.cos(Math.toRadians(player.getAngle())));
		player.changeY(-player.getVelocity()*Math.sin(Math.toRadians(player.getAngle())));
		
	}

	
	
}
