package player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

import javax.swing.JComponent;

import game.Coordinate;
import game.Game;

public class Player
{
	private Shape originalShape;
	private Shape shape;
	private Color color;
	private Game game;
	private Controller controller;
	
	public Player(Game game, Rectangle[] rects, Color color)
	{
		originalShape = SpriteCreator.combine(rects);
		shape = SpriteCreator.combine(rects);
		this.color = color;
		this.game = game;
		controller = Controller.getNextAvailableController(this);
		bindKeyMapsToScreen();
	}
	
	private void bindKeyMapsToScreen()
	{
		javax.swing.JPanel panel = game.getScreen().getPanel();
		panel.setInputMap(JComponent.WHEN_FOCUSED, controller.getInputMap());
		panel.setActionMap(controller.getActionMap());
		panel.requestFocus();
	}
	
	public Game getGame()
	{
		return game;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void transformShape(AffineTransform at)
	{
		shape = at.createTransformedShape(shape);
	}
	
	public Shape getShape()
	{
		return shape;
	}
	
	public Rectangle getBounds()
	{
		return shape.getBounds();
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public static Player[] createPlayers(int playerNum, Dimension screenSize, Game game)
	{
		final int softMaxPlayerAmount = 4;// also used for players allowed in 1 row to spawn
		Player[] players = new Player[playerNum];
		int squareWidth = 5;
		Color[] playerColors = new Color[]
		{ Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW };
		final int numOfRows = (int) Math.ceil((float) playerNum / softMaxPlayerAmount);
		final int horSpaceBetween = screenSize.width / ((playerNum < softMaxPlayerAmount ? playerNum : softMaxPlayerAmount) + 1);
		final int vertSpaceBetween = screenSize.height / (numOfRows + 1);
		for (int i = 0; i < playerNum; i++)
		{
			int f = i;
			while (f >= softMaxPlayerAmount)
				f -= 4;
			int rowsDown = (int) Math.ceil(((float) i + .001) / softMaxPlayerAmount);
			Coordinate offsetPoint = new Coordinate((f + 1) * horSpaceBetween, rowsDown * vertSpaceBetween);
			Rectangle[] rects = SpriteCreator.fourSquareArrowFormation(offsetPoint, squareWidth * 3, squareWidth * 2);
			players[i] = new Player(game, rects, playerColors[f]);
		}
		return players;
	}
}
