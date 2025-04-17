package im.ghosty.fullbrightplus.mixin.entity;

import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Optimizes the render method by not trying to find the light intensity.
 */
@Mixin(RendererLivingEntity.class)
public class RendererLivingEntityMixin {
	
	@Redirect(method = "setBrightness", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;getBrightness(F)F"))
	private float redirectGetBrightness(EntityLivingBase entity, float partialTicks) {
		return 1.0F;
	}
	
}
