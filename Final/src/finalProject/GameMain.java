package finalProject;
// I want you to see that I have committed
// I can see it
// test inside eclipse function
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class GameMain {
	public static void createGUI() {
		JFrame frame = new JFrame("Viewer");
		Car player1 = new Car(0,0,1);
		Car player2 = new Car(50,50,2);


		
		frame.add(new GamePanel(player1, player2, frame));
//		frame.add(obstacles);
//		frame.add(mud);
//		
//		obstacles.drawStuff();
		//frame.add(new MenuPanels(frame));
		frame.setSize(1500, 800);

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