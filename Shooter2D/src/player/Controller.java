package player;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import player.action.BombAction;
import player.action.MoveDownAction;
import player.action.MoveLeftAction;
import player.action.MoveRightAction;
import player.action.MoveUpAction;
import player.action.ShootAction;

public class Controller
{
	public ControlScheme controlScheme;
	private static int controlSchemeCounter = 0;
	
	private Controller(Player player, ControlScheme controlScheme)
	{
		this.controlScheme = controlScheme;
		controlScheme.bindActionsToPlayer(player);
	}
	
	public InputMap getInputMap()
	{
		return controlScheme.inMap;
	}
	
	/*
	 * Ensure ControlScheme.bindActionsToPlayer(Player) has been called first.
	 * Otherwise map will be empty.
	 */
	public ActionMap getActionMap()
	{
		return controlScheme.actMap;
	}
	
	public static Controller getNextAvailableController(Player pl)
	{
		controlSchemeCounter++;
		return new Controller(pl, ControlScheme.values()[controlSchemeCounter - 1]);
	}
	
	private enum ControlScheme
	{
		wasd("wasd", new String[]
		{ "W", "A", "S", "D", "F", "G" }), arrows("arrow-keys", new String[]
		{ "UP", "LEFT", "DOWN", "RIGHT", ",", "." });
		
		private InputMap inMap = new InputMap();
		private ActionMap actMap = new ActionMap();
		
		private ControlScheme(String name, String[] keys)
		{
			Action[] actions = Action.values();
			if (keys.length != actions.length) System.err.println("Improper fields in ControlScheme: " + name);
			for (int i = 0; i < actions.length; i++)
			{
				inMap.put(KeyStroke.getKeyStroke(keys[i]), actions[i]);
			}
		}
		
		public void bindActionsToPlayer(Player player)
		{
			for (Action action : Action.values())
			{
				try
				{
					actMap.put(action, action.getActionClass().getConstructor(Player.class).newInstance(player));
				}
				catch (Exception e)
				{
					System.err.println(e.getStackTrace());
				}
			}
		}
		
		enum Action
		{
			moveUp(MoveUpAction.class), moveLeft(MoveLeftAction.class), moveDown(MoveDownAction.class), moveRight(MoveRightAction.class), shoot(ShootAction.class), bomb(
					BombAction.class);
			
			private Class<? extends AbstractAction> actionClass;
			
			private Action(Class<? extends AbstractAction> actionClass)
			{
				this.actionClass = actionClass;
			}
			
			public Class<? extends AbstractAction> getActionClass()
			{
				return actionClass;
			}
		}
		
	}
	
}
