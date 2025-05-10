package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Car extends Vehicle{
	private int carNum;
	private BufferedImage image;
	private int x,y;
	private double angle;
	private int velocity;
	private int accel;
	private int WIDTH,HEIGHT;
	private int maxSpeed;
	
	public Car(int x, int y, int carNum) {
		super(x, y);
		maxSpeed = 14;
		accel = 2;
		angle = 90;
		this.carNum = carNum;
		switch(carNum) {
			case 1: try {
				image = ImageIO.read(new File("src/images/blueCar.png"));
			} catch (IOException e) {
				image = null;
				e.printStackTrace();
			} break;
			case 2: try {
				image = ImageIO.read(new File("src/images/purpleCar.png"));
			} catch (IOException e) {
				image = null;
				e.printStackTrace();
			} break;
			case 3: try {
				image = ImageIO.read(new File("src/images/whiteCar.png"));
			} catch (IOException e) {
				image = null;
				e.printStackTrace();
			} break;
			case 4: try {
				image = ImageIO.read(new File("src/images/brownCar.png"));
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
	
		
			
		public int getAccel() {
			return accel;
		}

		public int getMaxSpeed() {
			return maxSpeed;
		}
		public void boost(int boost) {
			velocity += boost;
		}
		//code to put image in
}


