 package org.diamond.dog;

import net.minecraft.client.renderer.entity.RenderSnowMan;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import org.apache.logging.log4j.Logger;

@Mod(modid = DogMod.MODID, name = DogMod.NAME, version = DogMod.VERSION)
public class DogMod
{
	@Mod.Instance
	public static DogMod instance;
	
    public static final String MODID = "org.diamond.dog";
    public static final String NAME = "Dog Mod";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        EntityRegistry.registerModEntity(new ResourceLocation(MODID + ":dog"), EntityDog.class, "Dog", 0, instance, 80, 1, true);
		RenderingRegistry.registerEntityRenderingHandler(EntityDog.class, new RenderFactory());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		logger.info("Init");
		MinecraftForge.EVENT_BUS.register(new DogEventHandler());
    }
}
