package finalProject;
// I want you to see that I have committed
// I can see it
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class GameMain {
	public static void createGUI() {
		JFrame frame = new JFrame("Viewer");
		frame.add(new MenuPanels(frame));
		frame.setSize(1800, 1080);
		frame.pack();
		frame.setLocationRelativeTo(null); // 2) center on screen
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// check pushing java file
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> createGUI());

	}

}
