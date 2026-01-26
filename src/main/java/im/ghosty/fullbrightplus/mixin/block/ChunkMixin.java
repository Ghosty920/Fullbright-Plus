package im.ghosty.fullbrightplus.mixin.block;

import im.ghosty.fullbrightplus.FBP;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Chunk.class)
public class ChunkMixin {
	
	@Inject(method = "getLightFor", at = @At("HEAD"), cancellable = true)
	public void fbp$getLightFor(EnumSkyBlock skyblock, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
		if (FBP.enabled)
			cir.setReturnValue(15);
	}
	
	@Inject(method = "getLightSubtracted", at = @At("HEAD"), cancellable = true)
	public void getLightSubtracted(BlockPos pos, int amount, CallbackInfoReturnable<Integer> cir) {
		if (FBP.enabled)
			cir.setReturnValue(15);
	}
	
}
