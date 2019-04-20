package org.diamond.dog;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

public class DogEventHandler
{
    @SubscribeEvent
    public void onBlockBreakEvent(BreakEvent event)
    {
    	String n = event.getState().getBlock().getUnlocalizedName();
    	if (n.equals("tile.grass")) {
    		World world = event.getWorld();
    		EntityPlayer player = event.getPlayer();
    		EntityDog dog = new EntityDog(world);
    		dog.setPosition(player.posX, player.posY, player.posZ);
    		dog.setTamedBy(player);
    		world.spawnEntity(dog);
    		event.setCanceled(true);
    	}
    }

}
