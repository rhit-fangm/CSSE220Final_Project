package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Vehicle extends JComponent{
	private double x, y;
	private int width, height;
	private int velocity;
	private double angle;
	private int accel;
	private int maxSpeed;
	private AbstractItem item;
	
	public Vehicle(int x, int y) {
		this.x =x;
		this.y = y;
		width = 80;
		height = 70;
		velocity = 0;
		item = null;
		
	}

	public int getVelocity() {
		return velocity;
	}

	public void changeVelocity(int velocity) {
		this.velocity += velocity;
	}
	
	public double getVehicleX() {
		return x;
	}

	public void changeX(double d) {
		this.x += d;
	}
	public void turnAngle(double degrees) {
		angle += degrees;
	}
	public double getAngle() {
		return angle;
	}

	public double getVehicleY() {
		return y;
	}

	public void changeY(double d) {
		this.y += d;
	}

	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void rotate(double degrees) {
		// TODO Auto-generated method stub
		
	}
	public int getWIDTH() {
		return width;
	}
	public int getHEIGHT() {
		return height;
	}

	public int getAccel() {
		return accel;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public AbstractItem getItem() {
		return item;
	}

	public void setItem(AbstractItem item) {
		this.item = item;
	}

	public void useItem() {
		
		
	}


	
}
