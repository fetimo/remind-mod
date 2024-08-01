package fetimo.remind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenStateManager {
    private static final Logger log = LoggerFactory.getLogger(ScreenStateManager.class);
    public static String remindScreen;
    public static Boolean isShowing = false;

    public static boolean shouldShowCustomScreen() {
        return remindScreen != null;
    }

    public static void setShowCustomScreen(String screen) {
        log.info("Setting screen to " + screen);
        remindScreen = screen;
    }

    public static void setIsShowing(Boolean show) {
        isShowing = show;
    }
}
