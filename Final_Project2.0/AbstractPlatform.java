package FinalProject;

public abstract class AbstractPlatform extends GameObject {

	public AbstractPlatform(int x, int y, int xVelocity, int yVelocity, GameComponent gameComponent, int width, int height) {
		super(gameComponent,x,y,xVelocity,yVelocity, width,height);
	}
	
	public abstract void removeDrop();
	public abstract void addDrop();
	public abstract void makeInvinciple();

}
