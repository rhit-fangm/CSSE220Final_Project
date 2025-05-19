
package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public abstract class Obstacle extends JComponent{
	private int x, y;
	private int length, height;
	private BufferedImage image;

	public Obstacle(int x, int y, int length, int height) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.height = height;
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getLength() {
		return length;
	}
	public int getHeight() {
		return height;
	}
	public BufferedImage getImage() {
		return image;
	}

	protected abstract void drawOn(Graphics g);
		
	protected abstract void collide(Vehicle player);

}
