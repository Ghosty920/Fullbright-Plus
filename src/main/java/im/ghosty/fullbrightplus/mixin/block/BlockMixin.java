package im.ghosty.fullbrightplus.mixin.block;

import im.ghosty.fullbrightplus.FBP;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {
	
	@Inject(method = "getMixedBrightnessForBlock", at = @At("HEAD"), cancellable = true)
	public void getMixedBrightnessForBlock(IBlockAccess worldIn, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
		if (FBP.enabled)
			cir.setReturnValue(Integer.MAX_VALUE);
	}
	
}
