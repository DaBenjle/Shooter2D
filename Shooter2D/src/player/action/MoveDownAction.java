package player.action;

import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;

import javax.swing.AbstractAction;

import player.Player;

public class MoveDownAction extends AbstractAction
{

	public Player player;
	
	public MoveDownAction(Player player)
	{
		this.player = player;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		AffineTransform at = AffineTransform.getTranslateInstance(0, 1);
		at.setToQuadrantRotation(3);
		player.transformShape(at);
	}
	
}
