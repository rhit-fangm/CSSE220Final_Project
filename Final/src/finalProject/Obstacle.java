package finalProject;

public class Obstacle {
	private int x, y;
	private int length, height;
	
	public Obstacle(int x, int y, int length, int height) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.height = height;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
