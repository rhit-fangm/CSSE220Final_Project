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

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel{
	private BufferedImage image;
	private final JFrame frame;
	private Vehicle player1;
	private Vehicle player2;

	

	public GamePanel(Vehicle player1, Vehicle player2, JFrame frame) {
		this.frame = frame;
		this.player1 = player1;
		this.player2 = player2;
		
		setPreferredSize(new Dimension(1530,1080));
		try {
			image = ImageIO.read(new File("src/images/titlepage.png"));
		} catch (IOException e) {
			System.err.println("Caught: " + e.getMessage());
			e.printStackTrace();
			image = null;
		}
		frame.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT: player1.turnAngle(-4.0); break;
				case KeyEvent.VK_RIGHT: player1.turnAngle(4.0); break;
			}
			}});
		frame.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
				case KeyEvent.VK_UP: 
					if(player1.getVelocity() < player1.getMaxSpeed()) {
						player1.changeVelocity(player1.getAccel()); break;
					}
					break;
				case KeyEvent.VK_DOWN:
					if(player1.getVelocity() > -5) {
						player1.changeVelocity(-player1.getAccel()); break;
					}
					break;
			}
			}});
		frame.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
				case KeyEvent.VK_A: player2.turnAngle(-4.0); break;
				case KeyEvent.VK_D: player2.turnAngle(4.0); break;
			}
			}});
		frame.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
				case KeyEvent.VK_W: 
					if(player2.getVelocity() < player2.getMaxSpeed()) {
						player2.changeVelocity(player2.getAccel()); break;
					}
					break;
				case KeyEvent.VK_S: 
					if(player2.getVelocity() > -5) {
						player2.changeVelocity(-player2.getAccel()); break;
					}
					break;
			}
			}});
		Timer animationTimer = new Timer(50, e -> updateListener());
		animationTimer.start();
	}
	
	
	
	//update listener using vector math temporarily
	private void updateListener() {
		
		player1.changeX(player1.getVelocity()*Math.cos(Math.toRadians(player1.getAngle())));
		player1.changeY(player1.getVelocity()*Math.sin(Math.toRadians(player1.getAngle())));
	//	player1.rotate();
		
		player2.changeX(player2.getVelocity()*Math.cos(Math.toRadians(player2.getAngle())));
		player2.changeY(player2.getVelocity()*Math.sin(Math.toRadians(player2.getAngle())));
	//	player2.rotate();
		repaint();
	}




	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(getGraphics());
		if(image != null) {
			//drawing background
			g.drawImage(image, 0, 0, this);
			
			//drawing player 1
			((Graphics2D) g).translate((int) player1.getVehicleX(), (int) player1.getVehicleY());
			((Graphics2D) g).rotate(Math.toRadians(player1.getAngle()), player1.getWIDTH()/2, player1.getHEIGHT()/2);
			g.drawImage(player1.getImage(), 0, 0 , player1.getWIDTH(), player1.getHEIGHT(), this);
			((Graphics2D) g).rotate(-Math.toRadians(player1.getAngle()), player1.getWIDTH()/2, player1.getHEIGHT()/2);
			((Graphics2D) g).translate(-(int) player1.getVehicleX(), -(int) player1.getVehicleY());
			
			//drawing player 2
			((Graphics2D) g).translate((int) player2.getVehicleX(), (int) player2.getVehicleY());
			((Graphics2D) g).rotate(Math.toRadians(player2.getAngle()), player2.getWIDTH()/2, player2.getHEIGHT()/2);
			g.drawImage(player2.getImage(), 0, 0 , player2.getWIDTH(), player2.getHEIGHT(), this);
			((Graphics2D) g).rotate(-Math.toRadians(player2.getAngle()), player2.getWIDTH()/2, player2.getHEIGHT()/2);
			((Graphics2D) g).translate(-(int) player2.getVehicleX(), -(int) player2.getVehicleY());
		} else {
			//setBackground(Color.RED);
			g.setColor(Color.BLACK);
			g.drawImage(player1.getImage(), (int) player1.getVehicleX(), (int) player1.getVehicleY(), player2.getWIDTH(), player2.getHEIGHT(),this);
			g.drawImage(player2.getImage(), (int) player2.getVehicleX(), (int) player2.getVehicleY(), player2.getWIDTH(), player2.getHEIGHT(),this);
		}
	}
}
