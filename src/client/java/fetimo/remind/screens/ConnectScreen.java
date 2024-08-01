package fetimo.remind.screens;

import fetimo.remind.ScreenStateManager;
import fetimo.remind.ServerTime;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

public class ConnectScreen extends Screen {
    public ConnectScreen(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        ScreenStateManager.setIsShowing(true);
        this.client.getToastManager().add(
            SystemToast.create(
                    this.client,
                    SystemToast.Type.NARRATOR_TOGGLE,
                    Text.of("Reminder"),
                    Text.of("Put your login time (" + ServerTime.main() +") in Discord")
            )
        );
        ScreenStateManager.setShowCustomScreen(null);
        ScreenStateManager.setIsShowing(false);

    }
}
