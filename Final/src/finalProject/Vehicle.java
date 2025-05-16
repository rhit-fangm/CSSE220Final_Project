package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
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
	private int turningRadius;
	
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
	public int getWidth() {
		return width;
	}
	public int getHeight() {
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

	public int getX() {
		return (int) x;
	}
	public int getY() {
		return (int) y;
	}
	public void useItem() {
		
		
	}

	public void draw() {
		
	}

	public Rectangle2D.Double getBoundingBox() {
		return new Rectangle2D.Double(this.x, this.y, this.width, this.height );
	}

	public int getTurningRadius() {
		return turningRadius;
	}

	public void setTurningRadius(int turningRadius) {
		this.turningRadius = turningRadius;
	}

	public void boost(int i) {
		// TODO Auto-generated method stub
		
	}

	public void addItem(BananaItem bananaItem) {
		// TODO Auto-generated method stub
		
	}


	
}
