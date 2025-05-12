package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public abstract class AbstractItem  extends JComponent{
	private int x,y;
	private BufferedImage image;
	private String name;
	public AbstractItem(int x, int y) {
		this.x = x;
		this.y = y;

	}
	
	
	

	
}
