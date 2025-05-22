package finalProject;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class PlayerGuide extends JComponent{
	private JButton exit;
	private Image controlImage;
	private boolean isClosed;
	public PlayerGuide() {
		setFocusable(true);
		exit = new JButton("Exit");
		try {
			controlImage = ImageIO.read(new File("src/images/guide.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		add(exit);
		exit.addActionListener(e -> exitGuide());
	}
	
	private void exitGuide() {
		this.setVisible(false);
		isClosed = true;
    }
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        if (controlImage != null) {
            g.drawImage(controlImage, 0, 0, getWidth(), getHeight(), this);
        }
	}

	public boolean isClosed() {
		// TODO Auto-generated method stub
		return isClosed;
	}
}