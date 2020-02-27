package player.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import player.Player;

public class MoveUpAction extends AbstractAction
{

	public Player player;
	
	public MoveUpAction(Player player)
	{
		this.player = player;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
}
