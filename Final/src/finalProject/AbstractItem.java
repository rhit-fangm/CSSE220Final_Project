package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public abstract class AbstractItem extends JComponent{
	private int id = 0;
	private BufferedImage image;

	public AbstractItem() {
	

	}
	protected abstract Image getImage();
	
	
	public int getId() {
		return id;
	}

	

	
}