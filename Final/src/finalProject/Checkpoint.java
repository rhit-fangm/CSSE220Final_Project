
package finalProject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Checkpoint extends Obstacle{
	private BufferedImage image;
	private int checkpointNum;
	public Checkpoint(int x, int y, int length, int height, int checkpointNum) {
		super(x, y, length, height);
		image = null;
	}

	@Override
	protected void drawOn(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void collide(Vehicle player) {
		if(player.getCheckpointNum() == 2) {
			System.out.println("You got one checkpoint");
			player.incLapNum();
			player.setCheckpointNum(0);
			System.out.println(player.getLapNum());
			if(player.getLapNum() == 3) {
				System.out.println("you win");
			}
		}
		if(player.getCheckpointNum() == 2 && checkpointNum == 3) {
			player.incLapNum();
			player.setCheckpointNum(0);
			System.out.println(player.getLapNum());
			if(player.getLapNum() == 3) {
				System.out.println("you win");
			}
		}
		if(player.getCheckpointNum() == 1 && checkpointNum == 2) {
			player.setCheckpointNum(checkpointNum);
		}
		if(player.getCheckpointNum() == 0 && checkpointNum == 1) {
			player.setCheckpointNum(checkpointNum);
		}
		
	}

}
