package FinalProject;

import java.awt.Graphics2D;

/**
 * A Platform that moves around the screen and absorbs Drops.
 * 
 * This platform never dies and when it reaches the edge of the screen
 * it stops there. If the user pressed a button the platform switches its current direction
 *
 */
public class UserControlPlatform extends AbstractPlatform {

	public static final int SIZE = 25;
	private static final int STARTING_DX = 3;
	private static final int STARTING_DY = 0;
	
	private static final int BOX_SIZE = 20;
	private static final int BOX_X = 10;
	private static final int BOX_Y = 200;

	public UserControlPlatform(int x, int y, int xVelocity, int yVelocity, GameComponent gameComponent) {
		super(x, y, xVelocity, yVelocity, gameComponent,SIZE , SIZE);
	}

	public UserControlPlatform(int width, int height, GameComponent gameComponent) {
		super(BOX_X, BOX_Y, STARTING_DX, STARTING_DY, gameComponent, SIZE, SIZE);
	}

	@Override
	public void update() {
		super.update();
		if ( isOffScreen()  ) {
			this.reverseDirection();
			super.update();
			this.reverseDirection();
		}
		
	}

	@Override
	public void collideWithPlatform(AbstractPlatform otherPlatform) {
	}
	
	
	@Override
	public void drawOn(Graphics2D g) {
		g.fill( this.getBoundingBox() );
	}

	@Override
	public void onRemove() {   
	}

	@Override
	public void removeDrop() {
	}
	
	@Override
	public void addDrop() {
	}
	
	@Override
	public void makeInvinciple() {
	}


}

