package im.ghosty.fullbrightplus.mixin.block;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Block.class)
public class BlockMixin {
	
	@SideOnly(Side.CLIENT)
	@Overwrite
	public int getMixedBrightnessForBlock(IBlockAccess worldIn, BlockPos pos) {
		return Integer.MAX_VALUE;
	}
	
}
