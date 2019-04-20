package org.diamond.dog;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFactory implements IRenderFactory<EntityDog>
{
    public Render<EntityDog> createRenderFor(RenderManager manager)
    {
    	return new RenderDog(manager);
    }
}
