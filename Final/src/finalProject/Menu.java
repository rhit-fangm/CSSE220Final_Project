package finalProject;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu extends JPanel {
    private Image titleScreen;
    private JButton startButton, singlePlayer, doublePlayer, guide;

    public Menu() {
        setFocusable(true);

        // Load title image
        try {
            titleScreen = ImageIO.read(new File("src/images/titlepage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create and add the start button
        startButton = new JButton("Start Game");
        singlePlayer = new JButton("Single Player");
        doublePlayer = new JButton("Double Player");
        guide = new JButton("Guide");
        add(startButton);
        add(singlePlayer);
        add(doublePlayer);
        add(guide);

    }

    public void addStartListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }
    
    public void addSingleListener(ActionListener listener) {
        singlePlayer.addActionListener(listener);
    }
    
    public void addDoubleListener(ActionListener listener) {
        doublePlayer.addActionListener(listener);
    }
    
    public void addguideListener(ActionListener listener) {
        guide.addActionListener(listener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (titleScreen != null) {
            g.drawImage(titleScreen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}