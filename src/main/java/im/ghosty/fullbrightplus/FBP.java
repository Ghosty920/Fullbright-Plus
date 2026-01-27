package im.ghosty.fullbrightplus;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = "fullbrightplus", clientSideOnly = true, useMetadata = true)
public final class FBP {
	
	public static boolean enabled = true;
	
	public static final KeyBinding keybind = new KeyBinding("Toggle Fullbright", Keyboard.KEY_G, "Fullbright Plus");
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ClientRegistry.registerKeyBinding(keybind);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onKey(InputEvent.KeyInputEvent event) {
		if(!keybind.isPressed()) return;
		enabled = !enabled;
	}
	
}
