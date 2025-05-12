package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Obstacle extends JComponent{
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
	
	public void drawOn(Graphics g) {
		if(image != null) {
			g.drawImage(image, x, y, length, height, this);
		}
	}
}
