package im.ghosty.fullbrightplus.mixin.other;

import im.ghosty.fullbrightplus.FBP;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.GuiIngameForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GuiIngameForge.class)
public class GuiIngameMixin {
	
	@Redirect(method = "renderGameOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;isFancyGraphicsEnabled()Z"))
	private boolean shouldShowVignette() {
		return !FBP.enabled && Minecraft.isFancyGraphicsEnabled();
	}
	
}
