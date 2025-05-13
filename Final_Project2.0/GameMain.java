package frame_and_Panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import daimaku.chekongzhi;
import daimaku.xiaoche;

/**
 * @author Daniel Sun This class is where the game starts at. First it creates a
 *         frame and ideally set the size to be the same scale as the player's
 *         screen. Second, it creates and loads the first game panel:
 *         startPanel.
 */
public class GameMain {
	private int panelcount;
	private JFrame frame;
	private StartPanel startPanel;
	private ModelPanel gameModelPanel;
	private chekongzhi singlePlayerPanel, doublePlayersPanel;
	private xiaoche player1, player2;
//	public static final int DELAY = 10;

	public static void main(String[] args) {
		new GameMain();
	}

	public GameMain() {
		frame = new JFrame("Racing Game");
		frame.setSize(1360, 768);
		// ---------------------------------------------------------------------------------
		// TODO: get the width and height of any screen that the game is running on and
		// set
		// the frame's size to be that
		// ---------------------------------------------------------------------------------

		// ---------------------------------------------------------------------------------
//		 Timer timer = new Timer(DELAY, null);
//		 timer.start();
		// TODO: implement the timer referencing to the upper two lines of code
		// ---------------------------------------------------------------------------------

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
					// double player button
					JButton doublePlayersButton = new JButton("Double Players");
					doublePlayersButton.setPreferredSize(new Dimension(200, 50));
					doublePlayersButton.addActionListener(new ButtonListener());
					gameModelPanel.add(doublePlayersButton, BorderLayout.SOUTH);
					// repaint and set visible to be true
					frame.repaint();
					frame.setVisible(true);
				}
			}
		});
		frame.setVisible(true); // initially set the frame to be visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonLabel = e.getActionCommand();
			if (buttonLabel.equals("Single Player")) {
				System.out.println("111");
			}
			if (buttonLabel.equals("Double Players")) {
				player1 = new xiaoche(0,0,1);
				player2 = new xiaoche(50,50,2);
				doublePlayersPanel = new chekongzhi(player1, player2, frame);
				frame.remove(gameModelPanel);
				frame.add(doublePlayersPanel);
				frame.repaint();
				frame.setVisible(true);
				System.out.println("2");
			}
		}
	}
}
