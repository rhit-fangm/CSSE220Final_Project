package finalProject;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class ObstacleComponent extends JComponent{
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	
	public ObstacleComponent() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for(Obstacle obstacle : obstacles) {
			obstacle.drawOn(g);
		}
	}
}
