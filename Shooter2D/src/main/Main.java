package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import bensAbstract.Screen;
import game.Game;

public class Main
{
	public JFrame frame;
	private Screen sc;
	private Game gm;
	
	public static void main(String[] args)
	{
		new Main();
	}
	
	public Main()
	{
		frame = initFrame();
		sc = new Screen(50)
				{
					@Override
					protected void update()
					{
						pixels = gm.update();
					}
				};
		sc.getPanel().setBackground(Color.WHITE);
		sc.getPanel().setFocusable(true);
		frame.add(sc.getPanel());
		
		gm = new Game(sc, 1, frame.getPreferredSize());
		sc.start();
	}
	
	public static JFrame initFrame()
	{
		JFrame frame = new JFrame("Shooter 2D");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		DisplayMode dm = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		frame.setPreferredSize(new Dimension(dm.getWidth(), dm.getHeight()));
		frame.setBackground(Color.BLACK);
		frame.pack();
		frame.repaint();
		return frame;
	}
}
