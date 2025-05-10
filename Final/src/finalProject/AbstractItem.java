package finalProject;

import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class AbstractItem  extends JComponent{
	private int playerNum;
	private BufferedImage image;
	public AbstractItem(int playerNum) {
		this.playerNum = playerNum;
	}
	
}
