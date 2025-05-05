package finalProject;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class GameMain {
	public static void createGUI() {
		JFrame frame = new JFrame("Viewer");
		
		frame.setSize(1920, 1080);
		
		frame.setLocationRelativeTo(null); // 2) center on screen
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> createGUI());

	}

}
