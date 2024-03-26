package SnakeGame;

import javax.swing.JFrame;

public class SnakeGame extends JFrame{
	
	SnakeGame(){
		super("SnakeGame");
		add(new Board());
		pack();
	//	setSize(300,300);
		setLocationRelativeTo(null);
		setResizable(false);
	
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SnakeGame().setVisible(true);
	}

}
