

package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {
	private BufferedImage image;
	private JFrame frame;
	private Vehicle player1;
	private Vehicle player2;
	private boolean left1, right1, up1, down1, left2, right2, up2, down2;
	private boolean p1Item, p2Item;
	private ObstacleComponent obstacles;
	private AbstractItem player1Item;
	private AbstractItem player2Item;

	public GamePanel(Vehicle player1, Vehicle player2, JFrame frame) {
		this.frame = frame;

		this.player1 = player1;
		this.player2 = player2;
		setPreferredSize(new Dimension(1530, 1080));
		try {
			image = ImageIO.read(new File("src/images/map1.png"));
		} catch (IOException e) {
			System.err.println("Caught: " + e.getMessage());
			e.printStackTrace();
			image = null;
		}
		obstacles = new ObstacleComponent(frame);
		player1.setItem(new Empty());
		player2.setItem(new Empty());

		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					left1 = true;
					break;
				case KeyEvent.VK_RIGHT:
					right1 = true;
					break;
				case KeyEvent.VK_UP:
					up1 = true;
					break;
				case KeyEvent.VK_DOWN:
					down1 = true;
					break;
				case KeyEvent.VK_A:
					left2 = true;
					break;
				case KeyEvent.VK_D:
					right2 = true;
					break;
				case KeyEvent.VK_W:
					up2 = true;
					break;
				case KeyEvent.VK_S:
					down2 = true;
					break;
				case KeyEvent.VK_SLASH:
					p1Item = true;
					break;
				case KeyEvent.VK_Q:
					p2Item = true;
					break;
				}
			}
		});
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					left1 = false;
					break;
				case KeyEvent.VK_RIGHT:
					right1 = false;
					break;
				case KeyEvent.VK_UP:
					up1 = false;
					break;
				case KeyEvent.VK_DOWN:
					down1 = false;
					break;
				case KeyEvent.VK_A:
					left2 = false;
					break;
				case KeyEvent.VK_D:
					right2 = false;
					break;
				case KeyEvent.VK_W:
					up2 = false;
					break;
				case KeyEvent.VK_S:
					down2 = false;
					break;
				case KeyEvent.VK_SLASH:
					p1Item = false;
					break;
				case KeyEvent.VK_Q:
					p2Item = false;
					break;
				}
			}
		});
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		Timer animationTimer = new Timer(50, e -> updateListener());
		animationTimer.start();
	}

	public GamePanel(Vehicle player2, JFrame frame) {
		this.frame = frame;

		this.player2 = player2;
		setPreferredSize(new Dimension(1530, 1080));
		try {
			image = ImageIO.read(new File("src/images/map1.png"));
		} catch (IOException e) {
			System.err.println("Caught: " + e.getMessage());
			e.printStackTrace();
			image = null;
		}
		obstacles = new ObstacleComponent(frame);
		player2.setItem(new Empty());

		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					left2 = true;
					break;
				case KeyEvent.VK_D:
					right2 = true;
					break;
				case KeyEvent.VK_W:
					up2 = true;
					break;
				case KeyEvent.VK_S:
					down2 = true;
					break;
				case KeyEvent.VK_Q:
					p2Item = true;
					break;
				}
			}
		});
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					left2 = false;
					break;
				case KeyEvent.VK_D:
					right2 = false;
					break;
				case KeyEvent.VK_W:
					up2 = false;
					break;
				case KeyEvent.VK_S:
					down2 = false;
					break;
				case KeyEvent.VK_Q:
					p2Item = false;
					break;
				}
			}
		});
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		Timer animationTimer = new Timer(50, e -> updateListener());
		animationTimer.start();
	}

	// update listener using vector math
	private void updateListener() {
		if (player1 != null) {
		if (left1) {
			player1.turnAngle(-player1.getTurningRadius());
		}
		
		if (right1) {
			player1.turnAngle(player1.getTurningRadius());
		}
		
		if (up1) {
			if (player1.getVelocity() < player1.getMaxSpeed()) {
				player1.changeVelocity(player1.getAccel());

			}
		}
		if (down1) {
			if (player1.getVelocity() > -5) {
				player1.changeVelocity(-player1.getAccel());
			}
		}
		
		if (player1.getVelocity() > 0) {
			player1.changeVelocity(-1);
		}
		if (player1.getVelocity() < 0) {
			player1.changeVelocity(1);
		}
		
		if (p1Item) {
			if(player1.getItem().getId() == 1) {
				obstacles.addObstacle(new OilObstacle((int) (player1.getX()-2*(player1.getWidth() * Math.cos(Math.toRadians(player1.getAngle())))),
						(int) (player1.getY()-2*(player1.getHeight() * Math.sin(Math.toRadians(player1.getAngle())))), 35, 35 ));
				
				player1.setItem(new Empty());
			}
			if(player1.getItem().getId() == 2) {
				obstacles.addObstacle(new BananaObstacle((int) (player1.getX()-2*(player1.getWidth() * Math.cos(Math.toRadians(player1.getAngle())))),
						(int) (player1.getY()-2*(player1.getHeight() * Math.sin(Math.toRadians(player1.getAngle())))), 25, 25 ));
				player1.setItem(new Empty());
				
			}
			if (player1.getItem() != null) {
				player1.useItem();
				player1.setItem(new Empty());
			}
		}
		
		obstacles.handleCollision(player1);
		
		player1.changeX(player1.getVelocity() * Math.cos(Math.toRadians(player1.getAngle())));
		player1.changeY(player1.getVelocity() * Math.sin(Math.toRadians(player1.getAngle())));
		}
		
		if (player2 != null) {
		if (left2) {
			player2.turnAngle(-player2.getTurningRadius());
		}
		
		if (right2) {
			player2.turnAngle(player2.getTurningRadius());
		}
		
		if (up2) {
			if (player2.getVelocity() < player2.getMaxSpeed()) {
				player2.changeVelocity(player2.getAccel());
			}
		}
		
		if (down2) {
			if (player2.getVelocity() > -5) {
				player2.changeVelocity(-player2.getAccel());
			}
		}
		
		if (player2.getVelocity() > 0) {
			player2.changeVelocity(-1);
		}
		if (player2.getVelocity() < 0) {
			player2.changeVelocity(1);
		}

		if (p2Item) {
			if(player2.getItem().getId() == 1) {
				obstacles.addObstacle(new OilObstacle((int) (player2.getX()-2*(player2.getWidth() * Math.cos(Math.toRadians(player2.getAngle())))),
						(int) (player2.getY()-2*(player2.getHeight() * Math.sin(Math.toRadians(player2.getAngle())))), 35, 35 ));
				
				player2.setItem(new Empty());
			}
			if(player2.getItem().getId() == 2) {
				obstacles.addObstacle(new BananaObstacle((int) (player2.getX()-2*player2.getWidth() * Math.cos(Math.toRadians(player2.getAngle()))),
						(int) (player2.getY()-2*(player2.getHeight() * Math.sin(Math.toRadians(player2.getAngle())))), 25, 25 ));
				player2.setItem(new Empty());
				
			}
			if (player2.getItem() != null) {
				player2.useItem();
				player2.setItem(new Empty());
			}
		}
		
		player2.changeX(player2.getVelocity() * Math.cos(Math.toRadians(player2.getAngle())));
		player2.changeY(player2.getVelocity() * Math.sin(Math.toRadians(player2.getAngle())));
		
		obstacles.handleCollision(player2);
		}
	
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			// drawing background
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			obstacles.drawStuff(g);

			// drawing player 1
			
			
			if (player1 != null) {
				g.drawImage(player1.getItem().getImage(), getWidth() - 100, 0, 100, 100, this);
				
				((Graphics2D) g).translate((int) player1.getVehicleX(), (int) player1.getVehicleY());
				((Graphics2D) g).rotate(Math.toRadians(player1.getAngle()), player1.getWidth() / 2,
						player1.getHeight() / 2);
				g.drawImage(player1.getImage(), 0, 0, player1.getWidth(), player1.getHeight(), this);
				((Graphics2D) g).rotate(-Math.toRadians(player1.getAngle()), player1.getWidth() / 2,
						player1.getHeight() / 2);
				((Graphics2D) g).translate(-(int) player1.getVehicleX(), -(int) player1.getVehicleY());
			}

			// drawing player 2
			if (player2 != null) {
				g.drawImage(player2.getItem().getImage(), 0, 0, 100, 100, this);
				
				((Graphics2D) g).translate((int) player2.getVehicleX(), (int) player2.getVehicleY());
				((Graphics2D) g).rotate(Math.toRadians(player2.getAngle()), player2.getWidth() / 2,
						player2.getHeight() / 2);
				g.drawImage(player2.getImage(), 0, 0, player2.getWidth(), player2.getHeight(), this);
				((Graphics2D) g).rotate(-Math.toRadians(player2.getAngle()), player2.getWidth() / 2,
						player2.getHeight() / 2);
				((Graphics2D) g).translate(-(int) player2.getVehicleX(), -(int) player2.getVehicleY());
			}
		}
	}
}
