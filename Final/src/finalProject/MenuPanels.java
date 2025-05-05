package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class MenuPanels extends JPanel{
private BufferedImage image;
	
	public MenuPanels() {
		setPreferredSize(new Dimension(300, 200));
		try {
			image = ImageIO.read(new File("src/images/SquareFaces.png"));
		} catch (IOException e) {
			System.err.println("Caught: " + e.getMessage());
			e.printStackTrace();
			playSoundEffect();
			image = null;
		}
	
	}
	
	private void playSoundEffect() {
		try {
			AudioInputStream a = AudioSystem.getAudioInputStream(new File("src/audio/bugle_tune.wav"));
			
			Clip clip = AudioSystem.getClip();
			
			clip.open(a);
			clip.start();
			
			
		} catch (UnsupportedAudioFileException e) {
			System.err.println("Caught: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Caught: " + e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e) {
			System.err.println("Caught: " + e.getMessage());
		}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(getGraphics());
		if(image != null) {
			int x = (getWidth() - image.getWidth())/2;
			int y = (getHeight() - image.getHeight())/2;
			g.drawImage(image, x, y, this);
		} else {
			//setBackground(Color.RED);
			g.setColor(Color.BLACK);
			g.drawString("Image not Found", 100, 100);
		}
	}
}
