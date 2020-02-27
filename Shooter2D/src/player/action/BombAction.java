package player.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import player.Player;

public class BombAction extends AbstractAction
{

	public Player player;
	
	public BombAction(Player player)
	{
		this.player = player;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Here");
		player.setColor(java.awt.Color.WHITE);
	}
	
}
