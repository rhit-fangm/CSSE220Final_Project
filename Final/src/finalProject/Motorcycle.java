package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Motorcycle extends Vehicle{

	private int motorNum;
	private BufferedImage image;
	private int x,y;
	private double angle;
	private int velocity;
	private int accel;
	private int WIDTH,HEIGHT;
	
	public Motorcycle(int x, int y, int motorNum, JFrame frame) {
		super(x, y, frame);
		this.motorNum = motorNum;
		switch(motorNum) {
			case 1: try {
				image = ImageIO.read(new File("src/images/blueMotorcycle.png"));
			} catch (IOException e) {
				image = null;
				e.printStackTrace();
			} break;
			case 2: try {
				image = ImageIO.read(new File("src/images/purpleMotorcycle.png"));
			} catch (IOException e) {
				image = null;
				e.printStackTrace();
			} break;
			case 3: try {
				image = ImageIO.read(new File("src/images/whiteMotorcycle.png"));
			} catch (IOException e) {
				image = null;
				e.printStackTrace();
			} break;
			case 4: try {
				image = ImageIO.read(new File("src/images/brownMotorcycle.png"));
			} catch (IOException e) {
				image = null;
				e.printStackTrace();
			} break;
		}
		}
	public BufferedImage getImage() {
		return image;
		
	}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(getGraphics());
			if(image != null) {
				g.drawImage(image, x, y, this);
			} else {
				//setBackground(Color.RED);
				g.setColor(Color.BLACK);
				g.drawString("Image not Found", 100, 100);
			}
			
		}

}
