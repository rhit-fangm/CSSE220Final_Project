package CardLayoutTest;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class carView extends JComponent{
	private static Image carImage;
	private static int carNum;
	public carView(int carNum) {
		this.carNum = carNum;
		carImageSelect(carNum);
		setVisible(true);
		setSize(500,500);
	}
	
	public Image carImageSelect(int carNum){
		switch (carNum) {
			case 1:
				try {
					carImage = ImageIO.read(new File("Final/src/images/blueCar.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				return carImage;
			case 2:
				try {
					carImage = ImageIO.read(new File("Final/src/images/brownCar.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				return carImage;
			case 3:
				try {
					carImage = ImageIO.read(new File("Final/src/images/purpleCar.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				return carImage;
			case 4:
				try {
					carImage = ImageIO.read(new File("Final/src/images/redRaceCar.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				return carImage;
			case 5:
				try {
					carImage = ImageIO.read(new File("Final/src/images/motorcycle.png"));
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
	public static Image getImage() {
		return carImage;
	}
}
