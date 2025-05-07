package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private BufferedImage image;
	private final JFrame frame;
	

	public GamePanel(Vehicle player1, Vehicle player2, JFrame frame) {
		this.frame = frame;
		setPreferredSize(new Dimension(1530,1080));
		try {
			image = ImageIO.read(new File("src/images/gamepage.png"));
		} catch (IOException e) {
			System.err.println("Caught: " + e.getMessage());
			e.printStackTrace();
			image = null;
		}
//		frame.addKeyListener(new KeyAdapter(){
//			@Override
//			public void keyPressed(KeyEvent e) {
//				
//			
//			switch(e.getKeyCode){
//				
//			}
//		});
		
		
	}
	
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(getGraphics());
		if(image != null) {
			g.drawImage(image, 0, 0, this);
		} else {
			//setBackground(Color.RED);
			g.setColor(Color.BLACK);
			g.drawString("Image not Found", 100, 100);
		}
	}
}
