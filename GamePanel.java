//Class to draw the grid of cells for the game of life

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GamePanel extends JPanel {

	private int height;
	private int width;
	private int size; //Size of each cell, in pixels
	private Game game;
	private double interval;
	
	public GamePanel(int size, int height, int width) {
		this.height = height;
		this.width = width;
		this.size = size;
		
		interval = 1.0;
		
		addMouseListener(new GameMouseListener());
	}
	
	public void gameStart() {
		game = new Game(size, height, width);
		game.initialize();
		game.addPulsar();
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int rows = height/size;
		int cols = width/size;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(game.getCellState(i,j)) {
					g.fillRect(i*size, j*size, size, size);
				}
			}
		}
	}
	
	public void start() { //Runs the game until the pause button is pressed on the frame
		game.start();
		repaint();
	}
	
	public void pause() {
		game.pause();
	}
	
	//Inner mouse listener class for creating new cells on mouse click
	class GameMouseListener implements MouseListener {
	
		public void mouseClicked(MouseEvent e) {
			if(game.isPaused()) { //Cell creation is only allowed while the game is paused
				int row = e.getX()/size;
				int col = e.getY()/size;
				game.create(row,col);
				repaint();
			}
		}
		
		public void mouseEntered(MouseEvent e) {}
		
		public void mouseExited(MouseEvent e) {}
		
		public void mousePressed(MouseEvent e) {}
		
		public void mouseReleased(MouseEvent e) {}

	}
	
	
	
}
		
