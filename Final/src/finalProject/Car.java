
package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Car extends Vehicle{
	private int carNum;
	private BufferedImage image;
	private int x,y;
	private int width, height;
	private double angle;
	private int velocity;
	private int accel;
	private int turningRadius;

	private int maxSpeed;
	
	public Car(int x, int y, int carNum, JFrame frame) {
		super(x, y, frame);
		maxSpeed = 14;
		accel = 2;
		angle = 90;
		width = (int) (frame.getWidth() * 0.05);
		height = (int) (frame.getHeight() * 0.07);
		this.carNum = carNum;
		turningRadius = 4;
		switch(carNum) {
			case 1: try {
				image = ImageIO.read(new File("Final/src/images/blueCar.png"));
			} catch (IOException e) {
				image = null;
				e.printStackTrace();
			} break;
			case 2: try {
				image = ImageIO.read(new File("Final/src/images/purpleCar.png"));
			} catch (IOException e) {
				image = null;
				e.printStackTrace();
			} break;
			case 3: try {
				image = ImageIO.read(new File("Final/src/images/whiteCar.png"));
			} catch (IOException e) {
				image = null;
				e.printStackTrace();
			} break;
			case 4: try {
				image = ImageIO.read(new File("Final/src/images/brownCar.png"));
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
				g.setColor(Color.BLACK);
				g.drawString("Image not Found", 100, 100);
			}
		}
		
		public int getAccel() {
			return accel;
		}

		public int getMaxSpeed() {
			return maxSpeed;
		}
		public void setMaxSpeed(int speed) {
			maxSpeed = speed;
		}
		
		public int getTurningRadius() {
			return turningRadius;
		}

		public void setTurningRadius(int turningRadius) {
			this.turningRadius = turningRadius;
		}
		
}


