package org.diamond.dog;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelDog extends ModelBase
{
    public ModelRenderer dogHeadMain;
    public ModelRenderer dogBody;
    public ModelRenderer dogLeg1;
    public ModelRenderer dogLeg2;
    public ModelRenderer dogLeg3;
    public ModelRenderer dogLeg4;
    ModelRenderer dogTail;
    ModelRenderer dogMane;

    public ModelDog()
    {
        float f = 0.0F;
        float f1 = 13.5F;
        dogHeadMain = new ModelRenderer(this, 0, 0);
        dogHeadMain.addBox(-2.0F, -3.0F, -2.0F, 6, 6, 4, 0.0F);
        dogHeadMain.setRotationPoint(-1.0F, 13.5F, -7.0F);
        dogBody = new ModelRenderer(this, 18, 14);
        dogBody.addBox(-3.0F, -2.0F, -3.0F, 6, 9, 6, 0.0F);
        dogBody.setRotationPoint(0.0F, 14.0F, 2.0F);
        dogMane = new ModelRenderer(this, 21, 0);
        dogMane.addBox(-3.0F, -3.0F, -3.0F, 8, 6, 7, 0.0F);
        dogMane.setRotationPoint(-1.0F, 14.0F, 2.0F);
        dogLeg1 = new ModelRenderer(this, 0, 18);
        dogLeg1.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        dogLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
        dogLeg2 = new ModelRenderer(this, 0, 18);
        dogLeg2.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        dogLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
        dogLeg3 = new ModelRenderer(this, 0, 18);
        dogLeg3.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        dogLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
        dogLeg4 = new ModelRenderer(this, 0, 18);
        dogLeg4.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        dogLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
        dogTail = new ModelRenderer(this, 9, 18);
        dogTail.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        dogTail.setRotationPoint(-1.0F, 12.0F, 8.0F);
        dogHeadMain.setTextureOffset(16, 14).addBox(-2.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
        dogHeadMain.setTextureOffset(16, 14).addBox(2.0F, -5.0F, 0.0F, 2, 2, 1, 0.0F);
        dogHeadMain.setTextureOffset(0, 10).addBox(-0.5F, 0.0F, -5.0F, 3, 3, 4, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        dogHeadMain.renderWithRotation(scale);
        dogBody.render(scale);
        dogLeg1.render(scale);
        dogLeg2.render(scale);
        dogLeg3.render(scale);
        dogLeg4.render(scale);
        dogTail.renderWithRotation(scale);
        dogMane.render(scale);
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
        EntityDog entitydog = (EntityDog)entitylivingbaseIn;
        dogTail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        dogBody.setRotationPoint(0.0F, 14.0F, 2.0F);
        dogBody.rotateAngleX = ((float)Math.PI / 2F);
        dogMane.setRotationPoint(-1.0F, 14.0F, -3.0F);
        dogMane.rotateAngleX = dogBody.rotateAngleX;
        dogTail.setRotationPoint(-1.0F, 12.0F, 8.0F);
        dogLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
        dogLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
        dogLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
        dogLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
        dogLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        dogLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        dogLeg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        dogLeg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        dogHeadMain.rotateAngleX = headPitch * 0.017453292F;
        dogHeadMain.rotateAngleY = netHeadYaw * 0.017453292F;
        dogTail.rotateAngleX = ageInTicks;
    }
}