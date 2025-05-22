package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class BananaObstacle extends Obstacle{

	private int x, y;
	private int length, height;
	private BufferedImage image;
	private GamePanel panel;
	public BananaObstacle(int x, int y, int length, int height) {
		super(x,y,length,height);
		
		try {
			image = ImageIO.read(new File("src/images/bananaObstacle.png"));
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
		player.changeVelocity(-player.getVelocity());
	}

	
	
}

