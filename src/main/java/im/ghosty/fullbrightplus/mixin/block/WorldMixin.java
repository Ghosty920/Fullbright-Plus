package im.ghosty.fullbrightplus.mixin.block;

import im.ghosty.fullbrightplus.FBP;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Disables recalculating light levels when blocks change and give the maximum light level of 15 whenever it is asked.
 * <p>
 * The game thread must be verified because if it is the IntegratedServer thread calling, it must have the real values.
 */
@Mixin(World.class)
public class WorldMixin {
	
	@Inject(method = "checkLightFor", at = @At("HEAD"), cancellable = true)
	private void fbp$checkLightFor(EnumSkyBlock lightType, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		if (FBP.enabled && Minecraft.getMinecraft().isCallingFromMinecraftThread())
			cir.setReturnValue(true);
	}
	
	@Inject(method = {"getLightFor", "getRawLight", "getLightFromNeighbors", "getLightFromNeighborsFor", "getLight(Lnet/minecraft/util/BlockPos;)I", "getLight(Lnet/minecraft/util/BlockPos;Z)I"}, at = @At("HEAD"), cancellable = true)
	private void fpb$getLight(CallbackInfoReturnable<Integer> cir) {
		if (FBP.enabled && Minecraft.getMinecraft().isCallingFromMinecraftThread())
			cir.setReturnValue(15);
	}
	
}
