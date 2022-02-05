package pong;
import java.awt.Graphics;


public interface Paddle {
	
	public void draw(Graphics g);
	public int getY();
	public int getX();
	public void checkCollision(int y);
	public void addPoint();
	public int getPlayer();

}
