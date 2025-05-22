package CardLayoutTest;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

class CarCanvas extends JComponent {
    private Image backgroundImage;
    private Image carImage;
    private int carNum;
    private carView cars;

    private double x = 150, y = 100; // Car position
    private double angle = 0;        // Rotation in radians
    int carWidth = 40;   // desired width in pixels
    int carHeight = 25;  // desired height in pixels


    private Timer timer;
    private final ArrayList<Integer> pressedKeys = new ArrayList<>();

    public CarCanvas(Image carImage) {
    	this.carImage = carImage;
        setFocusable(true);        // Required
        requestFocusInWindow();    // Ask for focus when shown
        // Load images
        try {
        	backgroundImage = ImageIO.read(new File("Final/src/images/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        // Key press tracking
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (!pressedKeys.contains(code)) {
                    pressedKeys.add(code);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Integer code = e.getKeyCode();
                pressedKeys.remove(code);
            }
        });
    }

    private void moveForward(double distance) {
        double newX = x + distance * Math.cos(angle);
        double newY = y + distance * Math.sin(angle);

        // Optional: bounds checking
        if (newX >= 0 && newX <= getWidth() && newY >= 0 && newY <= getHeight()) {
            x = newX;
            y = newY;
        }
    }

    public void startAnimation() {
        timer = new Timer(16, e -> {
            if (pressedKeys.contains(KeyEvent.VK_LEFT)) angle -= Math.toRadians(6);
            if (pressedKeys.contains(KeyEvent.VK_RIGHT)) angle += Math.toRadians(6);
            if (pressedKeys.contains(KeyEvent.VK_UP)) moveForward(8);
            if (pressedKeys.contains(KeyEvent.VK_DOWN)) moveForward(-3);

            repaint();
        });
        timer.start();
    }

    public void setCarSizeX(int carWidth) {
    	this.carWidth = carWidth;
    }
    public void setCarSizeY(int carHeight) {
    	this.carHeight = carHeight;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw background
        g2.drawImage(backgroundImage, 0, 0, 1200, 800, this);

        // Draw rotated car
        AffineTransform old = g2.getTransform();
        g2.translate(x, y);
        g2.rotate(angle);
        g2.drawImage(carImage, -carWidth / 2, -carHeight / 2, 50, 35, this);
        g2.setTransform(old);
        g2.dispose();
    }
}
