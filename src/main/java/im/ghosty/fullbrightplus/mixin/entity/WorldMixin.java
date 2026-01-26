package im.ghosty.fullbrightplus.mixin.entity;

import im.ghosty.fullbrightplus.FBP;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Sets the sun brightness as high as possible: makes like it's always midday.
 */
@Mixin(World.class)
public class WorldMixin {
	
	@Inject(method = "getSunBrightness", at = @At("HEAD"), cancellable = true)
	private void fbp$getSunBrightness(float partialTicks, CallbackInfoReturnable<Float> cir) {
		if (FBP.enabled)
			cir.setReturnValue(1.0F);
	}
	
}
