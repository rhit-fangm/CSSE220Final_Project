package finalProject;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
// I want you to see that I have committed
// I can see it
// test inside eclipse function
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class GameMain {
	private static int panelcount;
	private static JFrame frame;
	private static StartPanel startPanel;
	private static ModelPanel gameModelPanel;
	private static GamePanel singlePlayerPanel;
	private static GamePanel doublePlayersPanel;
	private static Car player1;
	private static Car player2;
//	public static final int DELAY = 10;
	
	public GameMain() {
		frame = new JFrame("Viewer");
		
		startPanel = new StartPanel();
		gameModelPanel = new ModelPanel(frame);
		panelcount = 0;
		
		frame.add(startPanel);

		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && panelcount == 0) {
					// remove start panel and add game model panel
					frame.remove(startPanel);
					frame.add(gameModelPanel);
					panelcount++;
					// single player button
					JButton singlePlayerButton = new JButton("Single Player");
					singlePlayerButton.setPreferredSize(new Dimension(200, 50));
					singlePlayerButton.addActionListener(new ButtonListener());
					gameModelPanel.add(singlePlayerButton, BorderLayout.SOUTH);
					gameModelPanel.setFocusable(true);
					gameModelPanel.requestFocusInWindow();
					// double player button
					JButton doublePlayersButton = new JButton("Double Players");
					doublePlayersButton.setPreferredSize(new Dimension(200, 50));
					doublePlayersButton.addActionListener(new ButtonListener());
					gameModelPanel.add(doublePlayersButton, BorderLayout.SOUTH);
					gameModelPanel.setFocusable(true);
					gameModelPanel.requestFocusInWindow();
					// repaint and set visible to be true
					frame.repaint();
					frame.setVisible(true);
				}
			}
		});

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
		frame.requestFocusInWindow();

		// check pushing java file

	}
	public static void main(String[] args) {
		new GameMain();
	}
	
	private static class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonLabel = e.getActionCommand();
			if (buttonLabel.equals("Single Player")) {
				player1 = new Car(0,0,1);
				singlePlayerPanel = new GamePanel(player1, frame);
				frame.remove(gameModelPanel);
				frame.add(singlePlayerPanel);
				frame.requestFocusInWindow();
				frame.repaint();
				frame.setVisible(true);
			}
			if (buttonLabel.equals("Double Players")) {
				player1 = new Car(0,0,1);
				player2 = new Car(50,50,2);
				doublePlayersPanel = new GamePanel(player1, player2, frame);
				frame.remove(gameModelPanel);
				frame.add(doublePlayersPanel);
				frame.requestFocusInWindow();
				frame.repaint();
				frame.setVisible(true);
			}
		}
	}
}
