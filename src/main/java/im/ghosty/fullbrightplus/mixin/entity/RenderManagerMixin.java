package im.ghosty.fullbrightplus.mixin.entity;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Optimizes the render method by not trying to find the light intensity.
 */
@Mixin(RenderManager.class)
public class RenderManagerMixin {
	
	@Redirect(method = "renderEntityStatic", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getBrightnessForRender(F)I"))
	private int redirectGetBrightnessForRender(Entity entity, float partialTicks) {
		return 0xf00000;
	}
	
}
