package SnakeGame;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//import javax.management.loading.PrivateClassLoader;
//import javax.swing.Action;
import javax.swing.ImageIcon;

import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{
	private Image rat;
	private Image dot;
	private Image snake; 
	private final int ALL_DOTS=900;	
	private final int DOTS_SIZE=10;
	private final int RANDOM_POSITION=29;
	private int rat_x;
	private int rat_y;
	private final int x[]=new int[ALL_DOTS];
	private final int y[]=new int[ALL_DOTS];
	private boolean leftDirection=false;
	private boolean rightDirection=true;
	private boolean upDirection=false;
	private boolean downDirection=false;
	private boolean inGame=true; 


	private int dots; 
 	private javax.swing.Timer timer;
		
	
	Board(){
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setPreferredSize(new Dimension(300,300));
		setFocusable(true);
		loadImages();
		initGame();
		requestFocus();
	}
	public void loadImages() {
		ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("SnakeGame/icons/rat.png"));
	    rat=i1.getImage();
		ImageIcon i2 =new ImageIcon(ClassLoader.getSystemResource("SnakeGame/icons/dot.png"));
		dot=i2.getImage();
		ImageIcon i3 =new ImageIcon(ClassLoader.getSystemResource("SnakeGame/icons/snake.png"));
		snake=i3.getImage();
	}
	public void initGame() {
		dots=3;
		for(int i=0;i<dots;i++) {
			y[i]=50;
			x[i]=50-i*DOTS_SIZE;
		}
		locateRat();
	    timer=new javax.swing.Timer(140, this);
		timer.start();
	    
	}
	public void locateRat() {
		int r =(int)(Math.random()*RANDOM_POSITION);
		rat_x=r*DOTS_SIZE;
		r =(int)(Math.random()*RANDOM_POSITION);
		rat_y=r*DOTS_SIZE;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		if(inGame) {
		   g.drawImage(rat,rat_x,rat_y,this);
		   for(int i=0;i<dots;i++) {
		  	   if(i==0) {
				   g.drawImage(snake,x[i], y[i],this);
				   }else {
					   g.drawImage(dot, x[i], y[i],this);
					
			       }
		}
		Toolkit.getDefaultToolkit().sync();
	}else {
		gameOver(g);
	}
	}
	public void gameOver(Graphics g) {
		String msg ="GameOver!";
		Font font = new Font("SAN_sERIF", Font.BOLD,14);
		FontMetrics metrics=getFontMetrics(font);
		g.setColor(Color.blue);
		g.drawString(msg, (300-metrics.stringWidth(msg))/2,300/2);
		
	}
	public void move() {
		for(int i=dots;i>0;i-- ) {
			x[i]=x[i-1];
			y[i]=y[i-1];
		}
		if (leftDirection) {
			x[0]-=DOTS_SIZE;
		}
		if (rightDirection) {
			x[0]+=DOTS_SIZE;
		}
		if (upDirection) {
			y[0]-=DOTS_SIZE;
		}
		if (downDirection) {
			y[0]+=DOTS_SIZE;
		}
	
	}
	public void checkApple() {
		if ((x [0]==rat_x)&&(y[0]==rat_y)) {
			dots++;
			locateRat();
		}
		
	}
	public void checkCollision() {
		for(int i=dots;i>0;i--) {
			if ((i>4)&&(x[0]==x[i])&&(y[0]==y[i])){
			inGame=false;
		}
	}
	if (y[0]>=300) {
		inGame=false;
	}
	if (x[0]>=300) {
		inGame=false;
	}
	if (y[0]<0) {
		inGame=false;
	}
	if (x[0]<0) {
		inGame=false;
	}
	if(!inGame) {
		timer.stop();
	}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (inGame) {
		  checkApple();
		  checkCollision();
	      move();
	      repaint();
		  }
		
	 }
	public class TAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int Key =e.getKeyCode();
			
			if (Key==KeyEvent.VK_LEFT&&(!rightDirection)) {
				leftDirection=true;
				upDirection=false;
				downDirection=false;
			}
			if (Key==KeyEvent.VK_RIGHT&&(!leftDirection)) {
				rightDirection=true;
				upDirection=false;
				downDirection=false;
			}
			if (Key==KeyEvent.VK_UP&&(!downDirection)) {
				upDirection=true;
				leftDirection=false;
				rightDirection=false;
			}
			if (Key==KeyEvent.VK_DOWN&&(!upDirection)) {
				downDirection=true;
				leftDirection=false;
				rightDirection=false;
			}
		}
	}
	
}
	
		
	
	

