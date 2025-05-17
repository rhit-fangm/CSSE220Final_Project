
package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Mudpatch extends Obstacle{
	
	private int x, y;
	private int length, height;
	private BufferedImage image;
	private GamePanel panel;
	private Timer t;
	public Mudpatch(int x, int y, int length, int height) {
		super(x,y,length,height);
		try {
			image = ImageIO.read(new File("Final/src/images/mudPatch.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("no image");
		}
	}
	public BufferedImage getImage() {
		return image;
	}
	

	@Override
	protected void drawOn(Graphics g) {
		if(image != null) {
			g.drawImage(image, x, y, length, height, null);
			
		}
		else {
			g.fillRect(x, y, length, height);
		}
		
	
	}
	
	@Override
	protected void collide(Vehicle player) {
		t = new Timer(2000, e -> slow5(player));
		player.setMaxSpeed(5);
		
		
	}
	private void slow5(Vehicle player) {
		t = null;
		player.setMaxSpeed(player.getMaxSpeed()*2);

	}
	
	
	
}
