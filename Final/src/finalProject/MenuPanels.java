package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuPanels extends JPanel{
private BufferedImage image;
private final JFrame frame;
private boolean enterPressed;
	
	public MenuPanels(JFrame frame) {
		this.frame = frame;
		this.enterPressed = enterPressed;
		enterPressed = false;
		setPreferredSize(new Dimension(1530,1080));
		try {
			image = ImageIO.read(new File("Final/src/images/titlepage.png"));
		} catch (IOException e) {
			System.err.println("Caught: " + e.getMessage());
			e.printStackTrace();
			image = null;
		}
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						enterPressed = true;
						image = ImageIO.read(new File("Final/src/images/whitecar.png"));
						repaint();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(getGraphics());
		if(image != null) {
			g.drawImage(image, 0, 0, this);
		} else {
			g.setColor(Color.BLACK);
			g.drawString("Image not Found", 100, 100);
		}
	}
}
