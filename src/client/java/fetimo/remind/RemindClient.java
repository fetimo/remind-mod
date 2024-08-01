package fetimo.remind;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RemindClient implements ClientModInitializer {
	private static final String TARGET_SERVER_IP = "209.54.116.200"; // AC IP
	private static final Boolean DEBUG = true;
	private static final Logger log = LogManager.getLogger(RemindClient.class);

	@Override
	public void onInitializeClient() {
		ClientPlayConnectionEvents.INIT.register((handler, client) -> {
			log.info("Client connected: " + handler.getConnection().getAddress().toString());

			if (DEBUG || isTargetServer(handler.getConnection().getAddress().toString())) {
				ScreenStateManager.setShowCustomScreen("connect");
			}
		});

		ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
			log.info("Client disconnected: " + handler.getConnection().getAddress().toString());
			if (DEBUG || isTargetServer(handler.getConnection().getAddress().toString())) {
				ScreenStateManager.setShowCustomScreen("disconnect");
			}
		});
	}

	private boolean isTargetServer(String serverAddress) {
		return serverAddress.contains(TARGET_SERVER_IP);
	}
}