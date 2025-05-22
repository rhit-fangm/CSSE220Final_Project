package finalProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class CarView extends JComponent{
	private BufferedImage carImage;
	private int carNum;
	public CarView(int carNum) {
		this.carNum = carNum;
		carImageSelect(carNum);
		setVisible(true);
		setSize(500,500);
	}
	
	public Image carImageSelect(int carNum){
		this.carNum = carNum;
		switch (carNum) {
			case 1:
				try {
					carImage = ImageIO.read(new File("src/images/blueCar.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				return carImage;
			case 2:
				try {
					carImage = ImageIO.read(new File("src/images/brownCar.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				return carImage;
			case 3:
				try {
					carImage = ImageIO.read(new File("src/images/purpleCar.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				return carImage;
			case 4:
				try {
					carImage = ImageIO.read(new File("src/images/whiteCar.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				return carImage;
			case 5:
				try {
					carImage = ImageIO.read(new File("src/images/redRaceCar.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				return carImage;
			case 6:
				try {
					carImage = ImageIO.read(new File("src/images/yellowSuperCar.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				return carImage;
		}
		return carImage;
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
        if (carImage != null) {
            g.drawImage(carImage, 0, 0, 1000, 700, this);
        }
	}
	public BufferedImage getImage() {
		return carImage;
	}
	public int getCarNum() {
		return carNum;
	}
}