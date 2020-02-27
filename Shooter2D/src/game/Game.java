package game;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import bensAbstract.Screen;
import player.Player;

public class Game
{
	private Player[] players;
	private Dimension screenSize;
	private Screen sc;
	
	public Game(Screen sc, int playerNum, Dimension screenSize)
	{
		this.sc = sc;
		this.screenSize = screenSize;
		players = Player.createPlayers(playerNum, screenSize, this);
	}
	
	public Screen getScreen()
	{
		return sc;
	}
	
	public int getPlayerNum()
	{
		return players.length;
	}
	
	/*
	 * @return pixels as a buffered image.
	 */
	public BufferedImage update()
	{
		BufferedImage pixels = new BufferedImage(screenSize.width, screenSize.height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = pixels.createGraphics();
		for(Player cur : players)
		{
			g2.setColor(cur.getColor());
			g2.draw(cur.getShape());
		}
		return pixels;
	}
}
