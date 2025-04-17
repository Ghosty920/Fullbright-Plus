package im.ghosty.fullbrightplus.mixin.entity;

import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/**
 * Sets the sun brightness as high as possible: makes like it's always midday.
 */
@Mixin(World.class)
public class WorldMixin {
	
	@SideOnly(Side.CLIENT)
	@Overwrite
	public float getSunBrightness(float partialTicks) {
		return 1.0F;
	}
	
}
