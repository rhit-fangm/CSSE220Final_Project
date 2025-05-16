package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public abstract class AbstractItem  extends JComponent{
	private int x,y;
	private BufferedImage image;

	public AbstractItem(int x, int y) {
		this.x = x;
		this.y = y;

	}
	protected abstract Image getImage();
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	

	
}
