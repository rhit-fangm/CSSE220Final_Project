package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class WaterPatch extends Obstacle{

	private int x, y;
	private int length, height;
	private BufferedImage image;
	private Timer t;
	
	public WaterPatch(int x, int y, int length, int height) {
		super(x,y,length,height);
		try {
			image = ImageIO.read(new File("src/images/waterPatch.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t = null;
	}
	public BufferedImage getImage() {
		return image;
	}
	
	
	@Override
	protected void drawOn(Graphics g) {
		if(image != null) {
			g.drawImage(image, x, y, length, height, this);
			System.out.println("adding image");
		}
		else {
			g.fillRect(x, y, length, height);
		}
		
	
	}

	@Override
	protected void collide(Vehicle player) {
		
		player.setTurningRadius(25);
		if(t==null) {
			helpCollide(player);
		}
		if(!t.isRunning()) {
			t.start();
		}
		
		
	}
	private void helpCollide(Vehicle player) {
		t = new Timer(3000, e -> spin(player));
	}
	private void spin(Vehicle player) {
		player.setTurningRadius(player.getOriginalTurningRadius());
		t.stop();
		
		
		

	}
	
	
}
