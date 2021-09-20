import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class BerlinClock {

    private BerlinClock() {}

    public static String getSeconds(int seconds) {
        return (seconds % 2 == 0) ? "Y" : "O";
    }

    public static String getHours(int hours) {
        StringBuilder sb = new StringBuilder();
        int lampsCountForFirstRow = hours / 5;
        int lampsCountForSecondRow = hours - 5 * lampsCountForFirstRow;
        addLamps(4, sb, getRegularConsumer(lampsCountForFirstRow, sb, "R"));
        sb.append(" ");
        addLamps(4, sb, getRegularConsumer(lampsCountForSecondRow, sb, "R"));
        return sb.toString();
    }

    public static String getMinutes(int minutes) {
        StringBuilder sb = new StringBuilder();
        int lampsCountForFirstRow = minutes / 5;
        int lampsCountForSecondRow = minutes - lampsCountForFirstRow * 5;
        addLamps(11, sb, getPersonalisedMinutesConsumer(lampsCountForFirstRow, sb));
        sb.append(" ");
        addLamps(4, sb, getRegularConsumer(lampsCountForSecondRow, sb, "Y"));
        return sb.toString();
    }

    public static String getTime(String time) {
        String[] timeElements = time.split(":");
        int hours = Integer.parseInt(timeElements[0]);
        int minutes = Integer.parseInt(timeElements[1]);
        int seconds = Integer.parseInt(timeElements[2]);
        if (hours > 23 || minutes > 59 || seconds > 59) {
            return  "";
        }
        return getSeconds(seconds) + " " + getHours(hours) + " " + getMinutes(minutes);
    }

    private static void addLamps(int maxLampsForRow, StringBuilder sb, IntConsumer consumer) {
        IntStream.rangeClosed(1, maxLampsForRow)
                .forEach(consumer);
    }

    private static IntConsumer getRegularConsumer(int lampsCount, StringBuilder sb, String lampColour) {
        return (i) -> sb.append(i <= lampsCount ? lampColour : "O");
    }

    private static IntConsumer getPersonalisedMinutesConsumer(int lampsCountForFirstRow, StringBuilder sb) {
        return (i) -> {
            boolean is15minuteMark = (i % 3) == 0;
            String minuteLampOnType = is15minuteMark ? "R" : "Y";
            sb.append(i <= lampsCountForFirstRow ? minuteLampOnType : "O");
        };
    }
}
