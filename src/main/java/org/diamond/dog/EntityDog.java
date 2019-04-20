package org.diamond.dog;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityDog extends EntityTameable
{
	public EntityDog(World w)
	{
		super(w);
        setSize(0.7F, 1.9F);
	}

    public EntityAgeable createChild(EntityAgeable ageable)
    {
    	return null;
    }

    protected void initEntityAI()
    {
        tasks.addTask(0, new EntityAIFollowOwner(this, 1, 5, 10));
    }

    public float getEyeHeight()
    {
        return 1.7F;
    }
}
