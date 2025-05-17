package finalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ObstacleComponent extends JComponent{
	private ArrayList<Obstacle> obstacles = new ArrayList<>();
	private ArrayList<Wall> walls = new ArrayList<>();

	public ObstacleComponent(JFrame frame) {
		
		
		Obstacle bush1 = new Bush( (int) (frame.getWidth() * 0.3),200,50,50);
		Obstacle bush2 = new Bush(150,300,75,75);
		Obstacle mud1 = new Mudpatch(800,200,50,50);
		Obstacle mud2 = new Mudpatch(350,100,75,75);
		Obstacle water1 = new WaterPatch(600,200,50,50);
		Obstacle water2 = new WaterPatch(550,100,75,75);
		Obstacle speed1 = new SpeedPanel(400,100,50,50);
		Obstacle speed2 = new SpeedPanel(450,500,75,75);
		Obstacle item1 = new ItemBox(700, 700, 50, 50);
		Wall wall1 = new Wall(280,350,100,10, 0);
		Wall wall2 = new Wall(380,350,100,10, 90);
		
		
		walls.add(wall1);
		walls.add(wall2);
		
		
		obstacles.add(bush1);
		obstacles.add(bush2);
		obstacles.add(mud1);
		obstacles.add(mud2);
		obstacles.add(water1);
		obstacles.add(water2);
		obstacles.add(speed1);
		obstacles.add(speed2);
		obstacles.add(item1);
		
		
		
	}
	public void drawStuff(Graphics g) {
		for(Obstacle obstacle : obstacles) {
			g.drawImage(obstacle.getImage(),obstacle.getX(),obstacle.getY(),obstacle.getLength(), obstacle.getHeight(),this);

		}
		for(Wall wall : walls) {
			((Graphics2D) g).translate((int) wall.getX(), (int) wall.getY());
			((Graphics2D) g).rotate(Math.toRadians(wall.getAngle()), wall.getWidth()/2, wall.getHeight()/2);
			g.drawImage(wall.getImage(),0,0,wall.getLength(), wall.getHeight(),this);
			((Graphics2D) g).rotate(-Math.toRadians(wall.getAngle()), wall.getWidth()/2, wall.getHeight()/2);
			((Graphics2D) g).translate((int) -wall.getX(), (int) -wall.getY());
		}
	}

	
	public void handleCollision(Vehicle player) {
		for(Obstacle obstacle : obstacles) {
			
			Rectangle2D.Double boundingBox = new Rectangle2D.Double(obstacle.getX()+obstacle.getLength()*0.1, obstacle.getY()+obstacle.getHeight()*0.1,obstacle.getLength()*0.9, obstacle.getHeight()*0.9);;
			if(boundingBox.intersects(player.getBoundingBox())) {
				obstacle.collide(player);

			}
			//System.out.println(obstacle.overlaps(player));

		}
		for(Obstacle wall : walls) {
			Rectangle2D.Double wallBoundingBox = new Rectangle2D.Double(wall.getX(), wall.getY(),wall.getLength(), wall.getHeight());;
			if(wallBoundingBox.intersects(player.getBoundingBox())) {
				wall.collide(player);
			}
		}
	}
	
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	public void addItem(Vehicle player) {
		
	}
	
}
