package pong;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class AI implements Paddle {

	double y,yVel;
	boolean up,down,perf,first;
	final double GRAVITY=.94;
	int player,x,score;
	
	public AI()
	{
		first=true;
		score=0;
		player=2;
		up=false; down=false; 
		y=210; yVel=0;
		x=1540;
		perf=(int)(Math.random()*3)==1?false:true;
	}
	
	public boolean perf()
	{
		if(first)
		{
			first=false;
			perf=true;
			return perf;
		}
		perf=(int)(Math.random()*3)==1?false:true;
		return perf;
	}
	
	
	public void checkCollision(int yG)
	{
		if(y<0){
			y+=10;
			yVel=-yVel;
			up=false;
			down=true;
		}
		else if(y+80>yG)
		{
			yVel=-yVel;
			y-=10;
			up=true;
			down=false;
		}
	}
	
	public void addPoint()
	{
		score++;
	}
	
	public int getPlayer()
	{
		return player;
	}
	
	public void move(Ball b) {
		if(perf){
			if(b.y<this.y)
				y-=5;
			else if(b.y>this.y)
				y+=5;
		}
		else
		{
			if(b.y<this.y)
				y-=4;
			else if(b.y>this.y)
				y+=4;
		}
			
	}
	
	

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 20, 80);
		g.setFont(new Font("TimesRoman",Font.PLAIN,25));
		g.drawString(score+"", 1560, 20);
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
}
