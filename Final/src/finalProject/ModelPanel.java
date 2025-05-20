
package finalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ModelPanel extends JPanel {
	private BufferedImage image;
//	private Vehicle vehicl1;
	public ModelPanel(JFrame frame) {
		setPreferredSize(new Dimension(1360, 768));
		try {
			image = ImageIO.read(new File("src/images/titlepage.png"));
			// ---------------------------------------------------------------------------------
			// playSoundEffect();
			// TODO: implement the sound effect
			// ---------------------------------------------------------------------------------
		} catch (IOException e) {
			System.err.println("Caught: " + e.getMessage());
			e.printStackTrace();
			// ---------------------------------------------------------------------------------
			// playSoundEffect();
			// TODO: implement the sound effect
			// ---------------------------------------------------------------------------------
			image = null;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(getGraphics());
		if (image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		} else {
			this.setBackground(Color.YELLOW);
			g.setColor(Color.RED);
			g.drawString("Image not found", 50, 50);
		}
	}

}
