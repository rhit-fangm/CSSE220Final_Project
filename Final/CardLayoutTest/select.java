package CardLayoutTest;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class select extends JPanel{
	private final JButton left, select, right;
	private static int carNum;
	private carView cars;
	public CarCanvas canvas, canvas2;
	private final JPanel selectPanel;
	private final JLabel pageLabel;
	private int maxNumOfCars;
	private  select select2;
	
	public select(int maxNumOfCars) {
		this.maxNumOfCars = maxNumOfCars;
		setPreferredSize(new Dimension(1200, 800));
		carNum = 1;
		pageLabel = new JLabel("Player one");
		left  = new JButton("<- Left");
		select  = new JButton("Select");
        right = new JButton("Right ->");
        cars = new carView(carNum);
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
			this.remove(selectPanel);
			canvas = new CarCanvas(cars.carImageSelect(carNum));
			add(canvas);
	        canvas.setBounds(0, 0, 1200, 800);
			canvas.setVisible(true);
			canvas.requestFocusInWindow();
			canvas.startAnimation();
		}else if(maxNumOfCars == 2) {
			removeAll();
			this.remove(selectPanel);
			canvas = new CarCanvas(cars.carImageSelect(carNum));
			select2 = new select(1);
            add(selectPanel);
            selectPanel.setVisible(true);        
            selectPanel.requestFocusInWindow();
		}
	}

	private void nextCar() {
		// TODO Auto-generated method stub
		if(carNum >=5) {
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
			carNum = 5;
			cars.carImageSelect(carNum);
		}else {
			carNum-=1;
			cars.carImageSelect(carNum);
		}
	}
}
