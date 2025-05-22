package CardLayoutTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardLayouttest {
	private static final int SCREEN_WIDTH = 1000;
	private static final int SCREEN_HEIGHT = 1000;
	public static menu menuPanel;
	public static select selectPanel, playerOne, playerTwo;
	public static playerGuide guide;

    public static void main(String[] args) {
        JFrame frame = new JFrame("What?Kart Demo");
		frame.setLayout(new java.awt.BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);

        menuPanel = new menu();
        menuPanel.setBounds(0, 0, 1200, 800);
                        
        frame.add(menuPanel);   
        
        menuPanel.addSingleListener(e->{
        	menuPanel.setVisible(false);  
            selectPanel = new select(1);
            frame.add(selectPanel);
            selectPanel.setVisible(true);        
            selectPanel.requestFocusInWindow();
        });
        
        menuPanel.addDoubleListener(e->{
        	menuPanel.setVisible(false);  
        	playerOne = new select(2);
        	frame.add(playerOne);
        });
        
        menuPanel.addguideListener(e->{
        	menuPanel.setVisible(false);  
        	guide = new playerGuide();
        	frame.add(guide);
        	guide.setVisible(true);
        	if(guide.isClosed()) {
        		menuPanel.setVisible(true);
        		guide.setVisible(false);
        	}
        });
        
        frame.setVisible(true);
    }
}
