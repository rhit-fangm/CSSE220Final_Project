
package finalProject;

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
		Obstacle bush1 = new Bush((int) (frame.getWidth() * 0.3), 200, 50, 50);
		Obstacle bush2 = new Bush(150, 300, 75, 75);
		Obstacle mud1 = new Mudpatch(800, 200, 50, 50);
		Obstacle mud2 = new Mudpatch(350, 100, 75, 75);
		Obstacle water1 = new WaterPatch(600, 200, 50, 50);
		Obstacle water2 = new WaterPatch(550, 100, 75, 75);
		Obstacle speed1 = new SpeedPanel(400, 100, 50, 50);
		Obstacle speed2 = new SpeedPanel(450, 500, 75, 75);
		Obstacle item1 = new ItemBox(700, 700, 50, 50);
		Obstacle wall1 = new Wall((int) (frame.getWidth() * 0.27), (int) (frame.getHeight() * 0.34), (int) (frame.getWidth() * 0.10), (int) (frame.getHeight() * 0.025), 0);
		obstacles.add(bush1);
		obstacles.add(bush2);
		obstacles.add(mud1);
		obstacles.add(mud2);
		obstacles.add(water1);
		obstacles.add(water2);
		obstacles.add(speed1);
		obstacles.add(speed2);
		obstacles.add(item1);
		obstacles.add(wall1);
	}

	public void drawStuff(Graphics g) {
		for (Obstacle obstacle : obstacles) {
			g.drawImage(obstacle.getImage(), obstacle.getX(), obstacle.getY(), obstacle.getLength(),
					obstacle.getHeight(), this);

		}

	}

	public void handleCollision(Vehicle player) {
		for (Obstacle obstacle : obstacles) {
			double shrinkFactor = 0.2;
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
