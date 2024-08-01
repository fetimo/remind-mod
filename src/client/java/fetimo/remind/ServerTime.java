package fetimo.remind;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ServerTime {
    public static String main() {
        // Step 1: Get the current local time
        LocalDateTime localDateTime = LocalDateTime.now();

        // Step 2: Define the target timezone
        ZoneId targetZoneId = ZoneId.of("America/New_York");  // Example target timezone

        // Step 3: Get the local timezone
        ZoneId localZoneId = ZoneId.systemDefault();

        // Step 4: Convert local time to ZonedDateTime
        ZonedDateTime localZonedDateTime = ZonedDateTime.of(localDateTime, localZoneId);

        // Step 5: Convert to the target timezone
        ZonedDateTime targetZonedDateTime = localZonedDateTime.withZoneSameInstant(targetZoneId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        return targetZonedDateTime.format(formatter);
    }
}
