package fetimo.remind.mixin.client;

import fetimo.remind.ScreenStateManager;
import fetimo.remind.screens.ConnectScreen;
import fetimo.remind.screens.DisconnectScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

	@Inject(method = "tick", at = @At("HEAD"))
	private void onTick(CallbackInfo info) {
		MinecraftClient client = MinecraftClient.getInstance();
		if (ScreenStateManager.shouldShowCustomScreen() && !ScreenStateManager.isShowing) {
			client.execute(() -> {
				if (ScreenStateManager.remindScreen.equals("connect")) {
					client.setScreen(
							new ConnectScreen(
									Text.of("Connected to Server")
							)
					);
				} else if (ScreenStateManager.remindScreen.equals("disconnect")) {
					client.setScreen(
							new DisconnectScreen(
									Text.of("Disconnected from Server")
							)
					);
				}
			});
		}
	}
}