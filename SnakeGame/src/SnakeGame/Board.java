package SnakeGame;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
	private Image head;
	private Image body;
	private Image tail; {
		
	}
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
			
		}
		
	}
}
