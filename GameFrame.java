//Class to create a JFrame that hosts the game panel and provides play/pause and save/load functionality

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameFrame extends JFrame {

	private GamePanel panel;
	private int size; //Cell size, in pixels
	private JButton play;
	private JButton pause;
	private int height;
	private int width;
	
	public GameFrame() {
		super("Game of Life");
		size = 5;
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JMenuBar bar = new JMenuBar();
		
		//File menu
		JMenu file = new JMenu("File");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem newItem = new JMenuItem("New");
		JMenuItem loadItem = new JMenuItem("Load");
		JMenuItem quitItem = new JMenuItem("Quit");
		newItem.addActionListener(new newItemListener());
		saveItem.addActionListener(new saveItemListener());
		loadItem.addActionListener(new loadItemListener());
		quitItem.addActionListener(new quitItemListener());
		file.add(newItem);
		file.add(saveItem);
		file.add(loadItem);
		file.add(quitItem);
		bar.add(file);
		
		//Play and pause buttons
		play = new JButton("Play");
		play.addActionListener(new playButtonListener());
		bar.add(play);
		pause = new JButton("Pause");
		pause.addActionListener(new pauseButtonListener());
		bar.add(pause);
		
		setJMenuBar(bar);
		
		//Height and width for the Game panel
		height = getHeight() - bar.getHeight();
		width = getWidth();
		
		panel = new GamePanel(size, height, width);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		panel.gameStart();
	}
	
	//Inner listener classes
	class newItemListener implements ActionListener {
	
		public void actionPerformed(ActionEvent event) {
			remove(panel);
			panel = new GamePanel(size, height, width);
			add(panel, BorderLayout.CENTER);
			setVisible(true);
			panel.gameStart();
		}
	}

	class saveItemListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {}

	}

	class loadItemListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {}
		
	}

	class quitItemListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
	
	class pauseButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			panel.pause();
		}
	}
	
	class playButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			panel.start();
		}
	}
		
	
}


