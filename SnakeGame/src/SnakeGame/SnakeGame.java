package SnakeGame;

import javax.swing.JFrame;

public class SnakeGame extends JFrame{
	SnakeGame(){
		super("SnakeGame");
		add(new Board());
		pack();
		setLocationRelativeTo(null);
		setSize(300,300);
		setVisible(true);
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SnakeGame();
	}

}
