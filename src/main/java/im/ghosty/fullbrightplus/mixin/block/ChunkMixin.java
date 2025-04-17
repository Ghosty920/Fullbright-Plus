package im.ghosty.fullbrightplus.mixin.block;

import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Chunk.class)
public class ChunkMixin {
	
	@Overwrite
	public int getLightFor(EnumSkyBlock skyBlock, BlockPos pos) {
		return 15;
	}
	
	@Overwrite
	public int getLightSubtracted(BlockPos pos, int amount) {
		return 15;
	}
	
}
