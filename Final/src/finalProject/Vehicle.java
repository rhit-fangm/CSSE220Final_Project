package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Vehicle extends JPanel{
	private int x, y;
	private final int WIDTH, HEIGHT;
	private int velocity;
	private double angle;
	
	public Vehicle(int x, int y) {
		this.x =x;
		this.y = y;
		WIDTH = 0;
		HEIGHT = 0;
		changeVelocity(0);
		angle = 0;
	}

	public int getVelocity() {
		return velocity;
	}

	public void changeVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getX() {
		return x;
	}

	public void changeX(int x) {
		this.x += x;
	}
	public void turnAngle(double degrees) {
		angle += degrees;
	}
	public double getAngle() {
		return angle;
	}

	public int getY() {
		return y;
	}

	public void changeY(int y) {
		this.y += y;
	}
}
