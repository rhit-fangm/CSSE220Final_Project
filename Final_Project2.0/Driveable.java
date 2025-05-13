package FinalProject;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public abstract class Driveable extends GameObject{
	private double x, y;
	private double velocity;
	private double acceleraction;
	private double angle;
	private int maxSpeed;
	private double width, height;
	private BufferedImage image;
	private HashMap<String, Boolean> controlcommands;
	
	public Driveable(int x, int y, HashMap controlcommands) {
		this.x = x;
		this.y = y;
		this.controlcommands = controlcommands;
	}
}
