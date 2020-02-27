package player.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import player.Player;

public class MoveRightAction extends AbstractAction
{

	public Player player;
	
	public MoveRightAction(Player player)
	{
		this.player = player;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Right");
	}
	
}
