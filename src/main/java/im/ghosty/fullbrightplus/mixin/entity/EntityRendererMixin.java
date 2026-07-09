package im.ghosty.fullbrightplus.mixin.entity;

import im.ghosty.fullbrightplus.FBP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.settings.GameSettings;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Prevents the lightmap from being regenerated. That's a pure lose of time as it's always as bright as possible, and the map will not change.
 */
@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
	
	@Unique
	private boolean fbp$torchFlickerSet = false;
	
	/**
	 * Torch Flicker is a semi-random method only used for updateLightmap.
	 * <p>
	 * I don't know the point of it, but anyway we don't need it at all, since we never need to regenate the map (the light will never change).
	 * <p>
	 * So we just generate a similar value once, then skip all calls if FBP is enabled.
	 */
	@Inject(method = "updateTorchFlicker", at = @At("HEAD"), cancellable = true)
	private void fbp$updateTorchFlicker(CallbackInfo ci) {
		if (!FBP.enabled) {
			fbp$torchFlickerSet = false;
			return;
		}
		if (fbp$torchFlickerSet) {
			ci.cancel();
			return;
		}
		fbp$torchFlickerSet = true;
	}
	
	/**
	 * It goes with the idea the gamma is VERY HIGH to boost values VERY HIGH too, to be sure it's the maximum value possible each time.
	 * <p>
	 * Not particularly required, but could help?
	 */
	@Redirect(method = "updateLightmap", at = @At(value = "FIELD", target = "Lnet/minecraft/client/settings/GameSettings;gammaSetting:F", ordinal = 0, opcode = Opcodes.GETFIELD))
	private float redirectGammaSetting(GameSettings gameSettings) {
		return FBP.enabled ? 100000.0F : gameSettings.gammaSetting;
	}
	
}
