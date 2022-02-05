package pong;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Player implements Paddle{

	double y,yVel;
	boolean up,down;
	final double GRAVITY=.94;
	int player,x,score;
	
	public Player(int play)
	{
		player=1;
		score=0;
		up=false; down=false;
		y=210; yVel=0;
		if(play==1)
			x=40;
		else
			x=620;
		
	}
	
	public void addPoint()
	{
		score++;
	}
	
	public void checkCollision(int yG)
	{
		if(y<0){
			y+=10;
			yVel=-yVel;
		}
		else if(y+80>yG)
		{
			yVel=-yVel;
			y-=10;
		}
	}
	
	public void move() {
	
		if(up)
		{
			yVel-=2;
		}
		else if(down)
		{
			yVel+=2;
		}
		else if(!up&&!down)
		{
			yVel*=GRAVITY;
		}
		y+=yVel;
	}

	public void draw(Graphics g) {
	
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 20, 80);
		g.setFont(new Font("TimesRoman",Font.PLAIN,25));
		g.drawString(score+"", 20, 20);
	}
	
	public void setUpAccel(boolean b)
	{
		up=b;
	}
	
	public void setDownAccel(boolean b)
	{
		down=b;
	}

	public int getY() {
		return (int)y;
	}
	
	public int getX()
	{
		return x;
	}

	@Override
	public int getPlayer() {
		return player;
		
	}

}
