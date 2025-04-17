package im.ghosty.fullbrightplus.mixin.block;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Minecraft.class)
public class MinecraftMixin {
	
	@Overwrite
	public static boolean isAmbientOcclusionEnabled() {
		return false;
	}
	
}
