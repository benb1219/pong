package pong;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.io.*;

import javax.swing.*;
import javax.swing.Timer;


public class Game extends Applet implements Runnable,KeyListener{
	
	boolean mess;
	final int WIDTH=1600,HEIGHT=900;
	Thread thread;
	Player p1;
	Ball b;
	AI a;

	
	public void init()
	{
		mess=false;
		this.setName("Pong!");
		thread=new Thread(this);
		this.addKeyListener(this);
		p1=new Player(1);
		a=new AI();
		this.resize(WIDTH, HEIGHT);
		b=new Ball(WIDTH/2,HEIGHT/2,5,5);
		thread.start();
	}
	
	public void paint(Graphics g)
	{
	g.setColor(Color.black);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	g.setColor(Color.white);
	g.fillRect(WIDTH/2, 0, 20, HEIGHT);
	p1.draw(g);
	a.draw(g);
	b.draw(g);
	if(mess)
	{
	mess=false;
	int z=-5;
	for(char c:"SERVE".toCharArray()){
		g.setColor(Color.white);
		g.drawString(c+"", WIDTH/2+z++, HEIGHT/2);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
	}
	

	
	public void update(Graphics g)
	{
		paint(g);
		
	}


	public void run() {
		for(;;)
		{
		p1.move();
		b.move();
		if(b.checkCollision(HEIGHT, WIDTH, p1,a,mess))
			a.perf();
		else if(b.checkCollision(HEIGHT, WIDTH, a,p1,mess))
			a.perf();
		if(mess)
			a.perf=true;
		mess=false;
		p1.checkCollision(HEIGHT);
		a.checkCollision(HEIGHT);
		a.move(b);
		ActionListener g=new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				repaint();
			}
		};
		
		new Timer(1000, g).start();
		
		try{
			Thread.sleep(10);
		}catch(InterruptedException e)
		{
			
		}
		}
	}


	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			p1.setUpAccel(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			p1.setDownAccel(true);
		}
	}


	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			p1.setUpAccel(false);
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			p1.setDownAccel(false);
		}
		
	}


	public void keyTyped(KeyEvent arg0) {
	
		
	}
	
	

}
