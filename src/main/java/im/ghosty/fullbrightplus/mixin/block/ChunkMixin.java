package im.ghosty.fullbrightplus.mixin.block;

import im.ghosty.fullbrightplus.FBP;
import net.minecraft.client.Minecraft;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Chunk.class)
public class ChunkMixin {
	
	@Inject(method = {"getLightFor", "getLightSubtracted"}, at = @At("HEAD"), cancellable = true)
	public void fbp$getLightFor(CallbackInfoReturnable<Integer> cir) {
		if (FBP.enabled && Minecraft.getMinecraft().isCallingFromMinecraftThread())
			cir.setReturnValue(15);
	}
	
}
