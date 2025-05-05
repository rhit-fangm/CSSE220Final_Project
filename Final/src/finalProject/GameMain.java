package finalProject;
// I want you to see that I have committed
// I can see it
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameMain {
//	public static void createGUI() {
//		JFrame frame = new JFrame("Viewer");
//		frame.add(new MenuPanels());
//		frame.setSize(1920, 1080);
//		frame.pack();
//		frame.setLocationRelativeTo(null); // 2) center on screen
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		
//		
//	}
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(() -> createGUI());
//
//	}
	public static void createGUI() {
		JFrame frame = new JFrame("Viewer");
<<<<<<< Updated upstream
		frame.add(new MenuPanels());
		frame.setSize(1800, 1080);
		frame.pack();
=======
		// Uncomment for Lab part 2
//		frame.setLayout(new java.awt.BorderLayout());
//		MyCanvas canvas = new MyCanvas();
//		frame.add(canvas, BorderLayout.CENTER);
//		ControlPanel control = new ControlPanel(canvas, frame);
//		frame.add(control, BorderLayout.SOUTH);

		frame.add(new ImagePanel());
		frame.setSize(600, 200);
//		frame.pack(); // 1) compute preferred size
>>>>>>> Stashed changes
		frame.setLocationRelativeTo(null); // 2) center on screen
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// uncomment for Lab part 2
		frame.requestFocusInWindow(); // 3) allow frame-level listener see the keys
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> createGUI());
	}

}
