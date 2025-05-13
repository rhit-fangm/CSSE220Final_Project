package daimaku;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class dache extends JComponent {
	private double x, y;
	private final int WIDTH, HEIGHT;
	private int velocity;
	private double angle;
	private int accel;
	private int maxSpeed;
	private BufferedImage image;
	private HashMap<String, Boolean> controlcommands;
	
	public dache(int x, int y, HashMap controlcommands) {
		this.x = x;
		this.y = y;
		this.controlcommands = controlcommands;
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

	public double getAngle() {
		return angle;
	}

	public void turnAngle(double degrees) {
		angle += degrees;
	}

	public void rotate(double degrees) {
		// TODO Auto-generated method stub
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
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

	public void update(int x, int y) {
		changeX(x);
		changeY(x);
	}

	public void drawOn(Graphics2D g2) {
	}
}
