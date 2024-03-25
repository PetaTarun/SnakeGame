package SnakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.management.loading.PrivateClassLoader;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
	private Image head;
	private Image body;
	private Image tail; 
	private final int ALL_DOTS=900;	
	private final int DOTS_SIZE=10;
	private final int RANDOM_POSITION=25;
	private int body_x;
	private int body_y;
	private final int x[]=new int[ALL_DOTS];
	private final int y[]=new int[ALL_DOTS];
	
	{
		
	}
	private int dots; {
		
	}
	Board(){
		setBackground(Color.black);
		setFocusable(true);
		loadImages();
		initGame();
	}
	public void loadImages() {
		ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("SnakeGame/icons/head.png"));
		head=i1.getImage();
		ImageIcon i2 =new ImageIcon(ClassLoader.getSystemResource("SnakeGame/icons/body.png"));
		body=i2.getImage();
		ImageIcon i3 =new ImageIcon(ClassLoader.getSystemResource("SnakeGame/icons/tail.png"));
		tail=i3.getImage();
	}
	public void initGame() {
		dots=3;
		for(int i=0;i<dots;i++) {
			y[i]=50;
			x[i]=50-i*DOTS_SIZE;
		}
		locateBody();
			
		
	}
	public void locateBody() {
		int r =(int)(Math.random()*RANDOM_POSITION);
		body_x=r*DOTS_SIZE;
		r =(int)(Math.random()*RANDOM_POSITION);
		body_y=r*DOTS_SIZE;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		g.drawImage(body, body_x, body_y,this);
		for(int i=0;i<dots;i++) {
			if(i==0) {
				g.drawImage(head, i, i,this);}
				else {
					g.drawImage(body, i, i,this);
					
				}
			}
		Toolkit.getDefaultToolkit().sync();
		}
	}

