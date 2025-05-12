package finalProject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShellItem extends AbstractItem{

	private int x,y;
	private BufferedImage image; 
	public ShellItem(int x, int y) {
		super(x, y);
		try {
			image = ImageIO.read(new File("src/images/blueCar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image != null) {
			g.drawImage(image, x, y, this);
		}
	}
	
	
}
