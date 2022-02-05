package pong;
import java.awt.Color;
import java.awt.Graphics;


public class Ball {
	
	public int xVel,yVel,x,y;
	
	public Ball(int x,int y, int yS, int xS)
	{
		this.x=x;
		this.y=y;
		this.xVel=xS;
		this.yVel=yS;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval(x, y, 20, 20);
	}
	
	public void move()
	{
		x+=xVel;
		y+=yVel;
	}

	public boolean checkCollision(int h, int w, Paddle p, Paddle p2,boolean m)
	{
		if(x<=0||x+20>=w){
			m=true;
			if(x<=0)
				p2.addPoint();
			else
				p.addPoint();
			x=w/2;
			y=h/2;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(y<=0||y+20>=h)
		{
			yVel=-yVel;
			return true;
		}
		if(y<p.getY()+80&&y+20>p.getY()&&x<p.getX()+20&&x+20>p.getX())
		{
				xVel=-xVel;
				if(p instanceof Player)
				if((int)Math.abs(x-p.getX())<5)
					x-=5;
				else
					x+=5;
				else
					if((int)Math.abs(x-p.getX())<5)
						x+=5;
					else
						x-=5;
					
				return true;
		}
		return false;
		
	}
	

}
