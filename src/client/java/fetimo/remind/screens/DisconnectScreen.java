package fetimo.remind.screens;

import fetimo.remind.ScreenStateManager;
import fetimo.remind.ServerTime;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DisconnectScreen extends Screen {
    private static final Logger log = LogManager.getLogger(DisconnectScreen.class);

    public DisconnectScreen(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        ScreenStateManager.setIsShowing(true);

        ButtonWidget buttonWidget = ButtonWidget.builder(Text.of("Done"), (btn) -> {
            // When the button is clicked, we can display a toast to the screen.
            ScreenStateManager.setShowCustomScreen(null);
            ScreenStateManager.setIsShowing(false);
            this.client.setScreen(null);
        }).dimensions(40, 40, 120, 20).build();

        // Register the button widget.
        this.addDrawableChild(buttonWidget);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        // Minecraft doesn't have a "label" widget, so we'll have to draw our own text.
        // We'll subtract the font height from the Y position to make the text appear above the button.
        // Subtracting an extra 10 pixels will give the text some padding.
        // textRenderer, text, x, y, color, hasShadow
        context.drawText(
                this.textRenderer,
                "Put your logout time (" + ServerTime.main() + ") and summary in Discord",
                40,
                40 - this.textRenderer.fontHeight - 10,
                0xFFFFFFFF,
                true
        );
    }
}
