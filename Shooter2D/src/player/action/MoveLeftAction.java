package player.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import player.Player;

public class MoveLeftAction extends AbstractAction
{

	public Player player;
	
	public MoveLeftAction(Player player)
	{
		this.player = player;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
}
