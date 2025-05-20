

package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class ObstacleComponent extends JComponent {
	private ArrayList<Obstacle> obstacles = new ArrayList<>();

	public ObstacleComponent(JFrame frame) {
		Obstacle bush1 = new Bush((int) (frame.getWidth() * 0.54), (int) (frame.getHeight() * 0.05),
				(int) (frame.getWidth() * 0.1), (int) (frame.getWidth() * 0.1));
		Obstacle bush2 = new Bush((int) (frame.getWidth() * 0.55), (int) (frame.getHeight() * 0.28),
				(int) (frame.getWidth() * 0.07), (int) (frame.getWidth() * 0.07));
		Obstacle mud1 = new Mudpatch((int) (frame.getWidth() * 0.57), (int) (frame.getHeight() * 0.2),
				(int) (frame.getWidth() * 0.08), (int) (frame.getWidth() * 0.08));
		Obstacle mud2 = new Mudpatch((int) (frame.getWidth() * 0.435), (int) (frame.getHeight() * 0.77),
				(int) (frame.getWidth() * 0.1), (int) (frame.getWidth() * 0.1));
		Obstacle water1 = new WaterPatch((int) (frame.getWidth() * 0.738), (int) (frame.getHeight() * 0.32),
				(int) (frame.getWidth() * 0.05), (int) (frame.getWidth() * 0.05));
		Obstacle water2 = new WaterPatch((int) (frame.getWidth() * 0.24), (int) (frame.getHeight() * 0.55),
				(int) (frame.getWidth() * 0.1), (int) (frame.getWidth() * 0.1));
		Obstacle water3 = new WaterPatch((int) (frame.getWidth() * 0.68), (int) (frame.getHeight() * 0.55),
				(int) (frame.getWidth() * 0.1), (int) (frame.getWidth() * 0.1));
		Obstacle speed1 = new SpeedPanel((int) (frame.getWidth() * 0.78), (int) (frame.getHeight() * 0.33),
				(int) (frame.getWidth() * 0.1), (int) (frame.getWidth() * 0.1));
		Obstacle speed2 = new SpeedPanel((int) (frame.getWidth() * 0.15), (int) (frame.getHeight() * 0.6),
				(int) (frame.getWidth() * 0.1), (int) (frame.getWidth() * 0.1));
		Obstacle item1 = new ItemBox((int) (frame.getWidth() * 0.8), (int) (frame.getHeight() * 0.5),
				(int) (frame.getWidth() * 0.05), (int) (frame.getWidth() * 0.05));
		Obstacle checkpoint1 = new Checkpoint((int) (frame.getWidth() * 0.33), (int) (frame.getHeight() * 0.13),
				(int) (frame.getWidth() * 0.01), (int) (frame.getHeight() * 0.2), 1);
		Obstacle checkpoint2 = new Checkpoint((int) (frame.getWidth() * 0.77), (int) (frame.getHeight() * 0.6),
				(int) (frame.getWidth() * 0.17), (int) (frame.getHeight() * 0.025), 2);
		Obstacle checkpoint3 = new Checkpoint((int) (frame.getWidth() * 0.05), (int) (frame.getHeight() * 0.5),
				(int) (frame.getWidth() * 0.23), (int) (frame.getHeight() * 0.022), 3);
		Obstacle wall1 = new Wall((int) (frame.getWidth() * 0.27), (int) (frame.getHeight() * 0.34),
				(int) (frame.getWidth() * 0.11), (int) (frame.getHeight() * 0.025), 0);
		Obstacle wall2 = new Wall((int) (frame.getWidth() * 0.38), (int) (frame.getHeight() * 0.34),
				(int) (frame.getWidth() * 0.01), (int) (frame.getHeight() * 0.2), 0);
		Obstacle wall3 = new Wall((int) (frame.getWidth() * 0.38), (int) (frame.getHeight() * 0.54),
				(int) (frame.getWidth() * 0.38), (int) (frame.getHeight() * 0.025), 0);
		Obstacle wall4 = new Wall((int) (frame.getWidth() * 0.76), (int) (frame.getHeight() * 0.345),
				(int) (frame.getWidth() * 0.01), (int) (frame.getHeight() * 0.28), 0);
		Obstacle wall5 = new Wall((int) (frame.getWidth() * 0.27), (int) (frame.getHeight() * 0.6),
				(int) (frame.getWidth() * 0.495), (int) (frame.getHeight() * 0.025), 0);
		Obstacle wall6 = new Wall((int) (frame.getWidth() * 0.27), (int) (frame.getHeight() * 0.34),
				(int) (frame.getWidth() * 0.01), (int) (frame.getHeight() * 0.285), 0);
		Obstacle wall7 = new Wall((int) (frame.getWidth() * 0.05), (int) (frame.getHeight() * 0.1),
				(int) (frame.getWidth() * 0.88), (int) (frame.getHeight() * 0.025), 0);
		Obstacle wall8 = new Wall((int) (frame.getWidth() * 0.05), (int) (frame.getHeight() * 0.87),
				(int) (frame.getWidth() * 0.88), (int) (frame.getHeight() * 0.025), 0);
		Obstacle wall9 = new Wall((int) (frame.getWidth() * 0.05), (int) (frame.getHeight() * 0.1),
				(int) (frame.getWidth() * 0.01), (int) (frame.getHeight() * 0.797), 0);
		Obstacle wall10 = new Wall((int) (frame.getWidth() * 0.93), (int) (frame.getHeight() * 0.1),
				(int) (frame.getWidth() * 0.01), (int) (frame.getHeight() * 0.797), 0);

		obstacles.add(mud1);
		obstacles.add(bush1);
		obstacles.add(bush2);
		obstacles.add(mud2);
		obstacles.add(water1);
		obstacles.add(water2);
		obstacles.add(water3);
		obstacles.add(speed1);
		obstacles.add(speed2);
		obstacles.add(item1);
		obstacles.add(wall1);
		obstacles.add(wall2);
		obstacles.add(wall3);
		obstacles.add(wall4);
		obstacles.add(wall5);
		obstacles.add(wall6);
		obstacles.add(wall7);
		obstacles.add(wall8);
		obstacles.add(wall9);
		obstacles.add(wall10);
		obstacles.add(checkpoint1);
		obstacles.add(checkpoint2);
		obstacles.add(checkpoint3);
	}

	public void drawStuff(Graphics g) {
		for (Obstacle obstacle : obstacles) {
			if (obstacle.getImage() != null) {
				g.drawImage(obstacle.getImage(), obstacle.getX(), obstacle.getY(), obstacle.getLength(),
						obstacle.getHeight(), this);
			} 
		}
	}

	public void handleCollision(Vehicle player) {
		for (Obstacle obstacle : obstacles) {
			double shrinkFactor = 0.99;
			if (!(obstacle instanceof Wall)) {
				shrinkFactor = 0.5;
			}
				double offsetX = (1 - shrinkFactor) / 2 * obstacle.getLength();
				double offsetY = (1 - shrinkFactor) / 2 * obstacle.getHeight();

				Rectangle2D.Double boundingBox = new Rectangle2D.Double(obstacle.getX() + offsetX,
						obstacle.getY() + offsetY, obstacle.getLength() * shrinkFactor,
						obstacle.getHeight() * shrinkFactor);
				
				if (boundingBox.intersects(player.getBoundingBox())) {
					obstacle.collide(player);

				}

			// System.out.println(obstacle.overlaps(player));

		}
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public void addItem(Vehicle player) {

	}

}
