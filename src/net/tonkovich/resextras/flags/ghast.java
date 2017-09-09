package net.tonkovich.resextras.flags;

import org.bukkit.entity.Ghast;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

public class ghast implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void Ghast(CreatureSpawnEvent event)
	{
		Residence residence = new Residence();
		FlagPermissions FlagPermissions = residence.getPermsByLoc(event.getLocation());
		LivingEntity Entity = event.getEntity();
		if (FlagPermissions == null)
			return;
		if (Entity instanceof Ghast)
		{
			if (FlagPermissions.has("ghast", true))
				return;
			event.setCancelled(true);
		}
	}
}