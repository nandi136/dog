package org.diamond.dog;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDog extends RenderLiving<EntityDog>
{
    private static final ResourceLocation WOLF_TEXTURES = new ResourceLocation("textures/entity/wolf/wolf.png");

    public RenderDog(RenderManager manager)
    {
        super(manager, new ModelDog(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityDog entity)
    {
        return WOLF_TEXTURES;
    }
}