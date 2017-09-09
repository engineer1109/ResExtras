package net.tonkovich.resextras.flags;

import org.bukkit.entity.Skeleton;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

public class skeleton implements Listener {

	@EventHandler(priority = EventPriority.NORMAL)
	public void Skeleton(CreatureSpawnEvent event)
	{
		FlagPermissions fp = Residence.getInstance().getPermsByLoc(event.getLocation());
		if (fp == null)
			return;
		LivingEntity Entity = event.getEntity();
		if (Entity instanceof Skeleton)
		{
			if (fp.has("skeleton", true))
				return;
			event.setCancelled(true);
		}
	}
}