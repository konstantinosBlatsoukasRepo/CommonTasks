package kon.blats.time;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by k.blatsoukas on 9/11/2017.
 */
public class TimeDifference {

    @Test
    public void differenceInMinutesAndHours() {
        String now = "2017-09-11 10:05:11";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime afterDateTime = LocalDateTime.parse(now, formatter);
        LocalDateTime currentDateTime = LocalDateTime.now();
        long diffInMinutes = ChronoUnit.MINUTES.between(currentDateTime, afterDateTime);
        long diffInHours = ChronoUnit.HOURS.between(afterDateTime, currentDateTime);
        System.out.println(diffInMinutes);
        System.out.println(diffInHours);
    }
}
