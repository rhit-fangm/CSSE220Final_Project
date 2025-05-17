
package finalProject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends Obstacle{
	private int x, y;
	private int length, height;
	private BufferedImage image;
	private GamePanel panel;
	private int angle;
	public Wall(int x, int y, int length, int height, int angle) {
		super(x,y,length,height);
		this.angle = angle;
		try {
			image = ImageIO.read(new File("Final/src/images/wall.png"));
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
	public double getAngle() {
		// TODO Auto-generated method stub
		return angle;
	}

	
	
}


