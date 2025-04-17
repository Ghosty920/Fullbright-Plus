package im.ghosty.fullbrightplus.mixin.entity;

import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.settings.GameSettings;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Prevents the lightmap from being regenerated. That's a pure lose of time as it's always as bright as possible, and the map will not change.
 */
@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
	
	@Shadow
	private float torchFlickerX;
	@Shadow
	private float torchFlickerDX;
	@Shadow
	private boolean lightmapUpdateNeeded;
	@Unique
	private boolean fbp$torchFlickerSet = false;
	
	/**
	 * Torch Flicker is a semi-random method that is only used for updateLightmap.
	 * <p>
	 * I don't know the point of it, but anyway we don't need it at all, since we never need to regenate the map (the light will never change).
	 * <p>
	 * So we just generate a similar value once, then skip all calls.
	 */
	@Overwrite
	public void updateTorchFlicker() {
		if (fbp$torchFlickerSet)
			return;
		fbp$torchFlickerSet = true;
		// completely made up formula, gives stuff around what the normal function does ¯\_(:3)_/¯
		// could probably even give like 0.1, but that wouldn't be fun (anyway it's not a big thing)
		torchFlickerX = torchFlickerDX = (float) ((1 - Math.sqrt(Math.random() * 2)) / 2);
		lightmapUpdateNeeded = true;
	}
	
	/**
	 * It goes with the idea the gamma is VERY HIGH to boost values VERY HIGH too, to be sure it's the maximum value possible each time.
	 */
	@Redirect(method = "updateLightmap", at = @At(value = "FIELD", target = "Lnet/minecraft/client/settings/GameSettings;gammaSetting:F", ordinal = 0))
	private float redirectGammaSetting(GameSettings gameSettings) {
		return 100000.0F;
	}
	
}
