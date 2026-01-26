package im.ghosty.fullbrightplus.mixin.block;

import im.ghosty.fullbrightplus.FBP;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MinecraftMixin {
	
	@Inject(method = "isAmbientOcclusionEnabled", at = @At("HEAD"), cancellable = true)
	private static void fbp$isAmbientOcclusionEnabled(CallbackInfoReturnable<Boolean> cir) {
		if (FBP.enabled)
			cir.setReturnValue(false);
	}
	
}
