package finalProject;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Select extends JPanel{
	private final JButton left, select, right;
	private static GamePanel singlePlayerPanel;
	private static GamePanel doublePlayersPanel;
	private static Vehicle player1;
	private static Vehicle player2;
	private static int carNum;
	private CarView cars;
	public int player1Num, player2Num;
	private final JPanel selectPanel;
	private final JLabel pageLabel;
	private int maxNumOfCars;
	private  Select select2;
	private JFrame frame;
	private boolean singlePlayer;
	
	public Select(int maxNumOfCars, JFrame frame, boolean singlePlayer) {

		this.singlePlayer = singlePlayer;
		this.maxNumOfCars = maxNumOfCars;
		this.frame = frame;
		setPreferredSize(new Dimension(1200, 800));
		carNum = 1;
		if(singlePlayer == true || (singlePlayer == false && maxNumOfCars == 1)){
			pageLabel = new JLabel("Player one");
		}
		else{
			pageLabel = new JLabel("Player two");
		}
		left  = new JButton("<- Left");
		select  = new JButton("Select");
        right = new JButton("Right ->");
        cars = new CarView(carNum);
        selectPanel = new JPanel();
        setLayout(new BorderLayout());
        add(pageLabel, BorderLayout.NORTH);
        add(cars, BorderLayout.CENTER);
        add(selectPanel, BorderLayout.SOUTH);
        
        selectPanel.add(left, BorderLayout.WEST);
        selectPanel.add(select, BorderLayout.CENTER);
        selectPanel.add(right, BorderLayout.EAST);

        left.addActionListener(e-> previousCar());
        select.addActionListener(e-> SelectCar());
        right.addActionListener(e -> nextCar());
	}

	private void SelectCar() {
		// TODO Auto-generated method stub
		if(maxNumOfCars == 1) {
			removeAll();
			remove(selectPanel);
			player1Num = cars.getCarNum();
        	start();
			
		}else if(maxNumOfCars == 2) {
			
			player2Num = cars.getCarNum();
        	maxNumOfCars = 1;
        	carNum = 1;
			cars.carImageSelect(carNum);
		}
	}

	

	public void start() {
		System.out.println(singlePlayer);
		
    	if(singlePlayer) {
        	player1 = new Car((int) (frame.getWidth() * 0.25), (int) (frame.getHeight() * 0.155), 1, player1Num, frame);
        	singlePlayerPanel = new GamePanel(player1, frame);
        	frame.add(singlePlayerPanel);
        	frame.requestFocusInWindow();
        	frame.repaint();
        	frame.setVisible(true);
        }
    	if(!singlePlayer){
    		
        	player1 = new Car((int) (frame.getWidth() * 0.25), (int) (frame.getHeight() * 0.155), 1, player1Num, frame);
 			player2 = new Car((int) (frame.getWidth() * 0.25), (int) (frame.getHeight() * 0.235), 2, player2Num, frame);
 			doublePlayersPanel = new GamePanel(player1, player2, frame);

 			frame.add(doublePlayersPanel);
 			frame.requestFocusInWindow();
 			frame.repaint();
 			frame.setVisible(true);
        }
    }

	private void nextCar() {
		// TODO Auto-generated method stub
		if(carNum >=6) {
			carNum = 1;
			cars.carImageSelect(carNum);
		}else {
			carNum+=1;
			cars.carImageSelect(carNum);
		}
	}

	private void previousCar() {
		// TODO Auto-generated method stub
		if(carNum == 1) {
			carNum = 6;
			cars.carImageSelect(carNum);
		}else {
			carNum-=1;
			cars.carImageSelect(carNum);
		}
	}
	public int getPlayerNum() {
		return player1Num;
	}
}