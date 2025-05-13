package FinalProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

import daimaku.dache;
import daimaku.xiaoche;

public class GameComponent extends JComponent {
	private ArrayList<dache> che = new ArrayList<>();

	public GameComponent(int che1) {
		this.che.add(new xiaoche(0, 0, che1));
	}
	
	public GameComponent(int che1, int che2) {
		this.che.add(new xiaoche(0, 0, che1));
		this.che.add(new xiaoche(50, 50, che2));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for (dache vehicle : this.che) {
			vehicle.drawOn(g2);
		}
	}
	
	public void updateState() {
		updateVehicles();
	}

	private void updateVehicles() {
		for (dache vehicle : che) {
			vehicle.update((int) vehicle.getVehicleX(), (int) vehicle.getVehicleY());
		}
	}
}
