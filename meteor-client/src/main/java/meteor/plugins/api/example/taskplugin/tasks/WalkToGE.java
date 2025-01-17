package meteor.plugins.api.example.taskplugin.tasks;

import meteor.PluginTask;
import meteor.plugins.api.commons.Rand;
import meteor.plugins.api.entities.Players;
import meteor.plugins.api.game.Game;
import meteor.plugins.api.movement.Movement;
import net.runelite.api.coords.WorldPoint;

public class WalkToGE implements PluginTask {
	private static final WorldPoint GE_LOCATION = new WorldPoint(3164, 3485, 0);

	@Override
	public boolean validate() {
		return GE_LOCATION.distanceTo(Players.getLocal()) > 15;
	}

	@Override
	public int execute() {
		if (Movement.isWalking()) {
			if (!Movement.isRunEnabled() && Game.getClient().getEnergy() > Rand.nextInt(5, 15)) {
				Movement.toggleRun();
			}

			return 1000;
		}

		Movement.walkTo(GE_LOCATION);
		return 1500;
	}
}
